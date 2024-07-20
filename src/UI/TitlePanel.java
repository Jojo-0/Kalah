package UI;

import javax.swing.*;

public class TitlePanel {
    private JPanel panel;

    public TitlePanel() {
        this.panel = new JPanel();
        JLabel titleLabel = new JLabel("Kalah");
        this.panel.add(titleLabel);
    }

    public JPanel getPanel() {
        return panel;
    }
}

