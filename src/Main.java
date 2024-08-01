import Test.Setup.TestRunner;
import UI.GameFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-t")) {
            TestRunner.runTests();
            return;
        }

        SwingUtilities.invokeLater(() -> {
            GameFrame gameFrame = new GameFrame();
            gameFrame.show();
            });
        }
    }