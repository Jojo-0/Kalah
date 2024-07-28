package UI;

import javax.swing.*;
import java.awt.*;

public class TitlePanel {
    private final JPanel panel;

    public TitlePanel() {
        this.panel = new JPanel();
        JLabel titleLabel = new JLabel("Kalaha");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36)); // Increase the font size
        this.panel.add(titleLabel);
    }

    public JPanel getPanel() {
        return panel;
    }
}

