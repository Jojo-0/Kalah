// copied from https://github.com/KlnSdr/AOP_SoSe23/blob/main/src/Sinking/http/test/Test.java
// Author: KlnSdr (Kilian Schneider)

package Test.Setup;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    String name();

    int order() default Integer.MAX_VALUE;
}