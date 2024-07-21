package UI;

import javax.swing.*;

public class TitlePanel {
    private final JPanel panel;

    public TitlePanel() {
        this.panel = new JPanel();
        JLabel titleLabel = new JLabel("Kalaha");
        this.panel.add(titleLabel);
    }

    public JPanel getPanel() {
        return panel;
    }
}

