// copied from https://github.com/KlnSdr/AOP_SoSe23/blob/main/src/Sinking/http/test/TestRunner.java
// Author: KlnSdr (Kilian Schneider)

package Test.Setup;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class TestRunner extends Classloader<Object> {
    //#region colors
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    private final ArrayList<Tripel<Class<?>, String, Method>> tests = new ArrayList<>();
    //#endregion
    private int executedTests = 0;
    private int passedTests = 0; // don't track failed test, think positive and track passed tests
    private int longestTestName = -1;

    private TestRunner(String packageName) {
        this.packageName = packageName;
    }

    public static void runTests() {
        TestRunner runner = new TestRunner("Test");
        runner.run();
    }

    public void run() {
        loadTests();

        if (longestTestName % 2 == 1) {
            longestTestName++;
        }
        System.out.printf("\n%s[TEST]%s\n", "=".repeat(longestTestName / 2 - 2), "=".repeat(longestTestName / 2 - 2));
        executeTest(0);
    }

    private void executeTest(int index) {
        if (index >= tests.size()) {
            System.out.println("=".repeat(longestTestName + 2));
            System.out.println("Tests:\t" + executedTests);
            System.out.println("PASSED:\t" + passedTests + "\t(" + (passedTests * 100 / executedTests) + "%)");
            System.out.println("FAILED:\t" + (executedTests - passedTests) + "\t(" + ((executedTests - passedTests) * 100 / executedTests) + "%)");
            System.out.println("=".repeat(longestTestName + 2));
            return;
        }
        Tripel<Class<?>, String, Method> test = tests.get(index);
        String title = test._1().getSimpleName() + " -> " + test._2();
        System.out.printf("[%s%s]", title, " ".repeat(longestTestName - title.length()));

        Method actualTest = test._3();
        executedTests++;
        try {
            actualTest.invoke(test._1().getDeclaredConstructor().newInstance(), (ITestResult) (result) -> {
                if (result) {
                    passedTests++;
                    System.out.println(colorize(GREEN, " PASSED"));
                } else {
                    System.out.println(colorize(RED, " FAILED"));
                }
                executeTest(index + 1);
            });
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | IllegalArgumentException |
                 InstantiationException e) {
            System.out.println(colorize(RED, " FAILED"));
            e.printStackTrace();
            executeTest(index + 1);
        }
    }

    private void loadTests() {
        loadClasses().forEach(this::analyzeClassAndMethods);
        sortTests();
    }

    private void sortTests() {
        Tripel<Class<?>, String, Method>[] array = new Tripel[tests.size()];
        array = tests.toArray(array);
        // https://stackoverflow.com/a/1099389/13079323
        Arrays.sort(array, (o1, o2) -> {
            Method m1 = o1._3();
            Method m2 = o2._3();

            Test or1 = m1.getAnnotation(Test.class);
            Test or2 = m2.getAnnotation(Test.class);
            // nulls last
            if (or1 != null && or2 != null) {
                return or1.order() - or2.order();
            } else if (or1 != null) {
                return -1;
            } else if (or2 != null) {
                return 1;
            }
            return -1;
        });
        tests.clear();
        tests.addAll(Arrays.asList(array));
    }

    private void analyzeClassAndMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.isAnnotationPresent(Test.class) || !isValidTestMethod(method)) {
                continue;
            }

            Test annotation = method.getAnnotation(Test.class);
            String testTitle = annotation.name();

            int testTitleLength = testTitle.length() + 4 /* -> */ + clazz.getSimpleName().length();
            if (testTitleLength > longestTestName) {
                longestTestName = testTitleLength;
            }

            tests.add(new Tripel<Class<?>, String, Method>(clazz, testTitle, method));
        }
    }

    private boolean isValidTestMethod(Method method) {
        Type[] paramTypes = method.getGenericParameterTypes();
        return paramTypes.length == 1 && paramTypes[0] == ITestResult.class;
    }

    @Override
    protected Class<?> filterClasses(String line) {
        return defaultClassFilter(line);
    }


    private String colorize(String color, String text) {
        return color + text + "\033[0m";
    }
}
