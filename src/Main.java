import Test.Setup.TestRunner;
import UI.GameFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TestRunner.runTests();
        SwingUtilities.invokeLater(() -> {
            GameFrame gameFrame = new GameFrame();
            gameFrame.show();
            });
        }
    }