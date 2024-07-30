package UI;

import javax.swing.*;
import java.awt.*;

public class CommandPanel {
    private final JPanel panel;
    private static JTextField commandTextField;

    public CommandPanel() {
        panel = new JPanel();
        commandTextField = new JTextField (25);
        commandTextField.setEditable(false);
        commandTextField.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(commandTextField);
    }

    public JPanel getPanel() {
        return panel;
    }

    public static void setCommandText(String text) {
        commandTextField.setText(text);
    }
}
