package UI;

import javax.swing.*;

public class CommandPanel {
    private final JPanel panel;
    private static JTextField commandTextField;

    public CommandPanel() {
        panel = new JPanel();
        commandTextField = new JTextField(40);
        commandTextField.setEditable(false);
        panel.add(commandTextField);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setCommandText(String text) {
        commandTextField.setText(text);
    }
}
