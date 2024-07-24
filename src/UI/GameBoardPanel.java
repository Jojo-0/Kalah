package UI;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel {
    private final JPanel panel;
    private final JButton[] buttons;

    public GameBoardPanel(GameFrame gameFrame) {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        buttons = new JButton[14]; // 14 cells including the 2 bases

        // Layout configuration
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create buttons and set initial labels
        for (int i = 0; i < 14; i++) {
            String buttonLabel = (i == 0 || i == 7) ? "Base" : "4"; // Bases or initial 4 stones
            JButton button = new JButton(buttonLabel);
            button.addActionListener(new GameActionListener(gameFrame));
            buttons[i] = button; // Store reference to the button

            if (i == 0) { // Base of player 1
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 2; // Span 2 rows
                panel.add(button, gbc);
            } else if (i == 7) { // Base of player 2
                gbc.gridx = 7;
                gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 2; // Span 2 rows
                panel.add(button, gbc);
            } else if (i < 7) { // Top row cells (indexes 1 to 6)
                gbc.gridx = i;
                gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                panel.add(button, gbc);
            } else { // Bottom row cells (indexes 8 to 13) from right to left
                gbc.gridx = 14 - i; // Shift index for bottom row from right to left
                gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                panel.add(button, gbc);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton[] getButtons() {
        return buttons;
    }

    public void updateButtonStoneCount(int index, int stones) {
        if (index < 0 || index >= buttons.length) return;
        JButton button = buttons[index];
        button.setText(String.valueOf(stones));
    }

}
