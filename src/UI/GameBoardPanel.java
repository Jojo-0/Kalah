package UI;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel {
    private final JPanel panel;
    private final JButton[] buttons;

    public GameBoardPanel(GameFrame gameFrame) {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        buttons = new JButton[12]; // 12 cells excluding the 2 bases

        // Define the buttons for the gameboard
        for (int i = 0; i < 14; i++) {
            String buttonLabel;
            if (i == 0 || i == 7) {
                buttonLabel = "Base"; // Bases are initially empty
            } else {
                buttonLabel = "4"; // Each cell initially contains 4 stones
            }

            JButton button = new JButton(buttonLabel);
            button.addActionListener(new GameActionListener(gameFrame));

            if (i == 0) { // Base of player 1
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 2; // Span 2 rows
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                panel.add(button, gbc);
            } else if (i == 7) { // Base of player 2
                gbc.gridx = 7;
                gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 2; // Span 2 rows
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                panel.add(button, gbc);
            } else {
                int index = (i < 7) ? i - 1 : i - 2; // Adjust index for button array

                gbc.gridx = (index % 6) + 1; // Columns: 1 to 6
                gbc.gridy = (index / 6); // Row 0
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                panel.add(button, gbc);

                buttons[index] = button; // Store reference to the button
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

    public void updateBaseStoneCount(int index, int stones) {
        if (index != 0 && index !=7) return;

        JButton button = buttons[index];
        button.setText("Base: \n" + stones);
    }
}