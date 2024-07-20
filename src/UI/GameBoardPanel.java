package UI;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel {
    private JPanel panel;
    private JButton[] buttons;

    public GameBoardPanel(GameFrame gameFrame) { // Accept reference to GameFrame
        panel = new JPanel(new GridBagLayout()); // Use GridBagLayout for flexible grid-based layout
        GridBagConstraints gbc = new GridBagConstraints(); // Define constraints for GridBagLayout

        buttons = new JButton[14]; // Create an array to hold references to the buttons

        // Define the buttons for the gameboard
        for (int i = 0; i < 16; i++) { // Loop through 16 cells
            String buttonLabel;
            if (i == 0 || i == 7) {
                buttonLabel = "Base"; // Bases are initially empty
            } else if (i < 8) {
                buttonLabel = "4"; // Each cell initially contains 4 stones for Player 1
            } else {
                buttonLabel = "4"; // Each cell initially contains 4 stones for Player 2
            }

            JButton button = new JButton(buttonLabel); // Create a button with the number of stones
            button.addActionListener(new GameActionListener(gameFrame)); // Add action listener to the button

            if (i == 0) { // First button, base of player 1
                gbc.gridx = 0; // Position at the first column
                gbc.gridy = 0; // Position at the first row
                gbc.gridwidth = 1; // Span only 1 column
                gbc.gridheight = 2; // Span 2 rows
                gbc.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
                gbc.weightx = 1.0; // Give equal horizontal space to all cells
                gbc.weighty = 1.0; // Give equal vertical space to all cells
                panel.add(button, gbc); // Add button to the panel with specified constraints
            } else if (i == 7) { // Eighth button, base of player 2
                gbc.gridx = 7; // Position at the eighth column
                gbc.gridy = 0; // Position at the first row
                gbc.gridwidth = 1; // Span only 1 column
                gbc.gridheight = 2; // Span 2 rows
                gbc.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
                gbc.weightx = 1.0; // Give equal horizontal space to all cells
                gbc.weighty = 1.0; // Give equal vertical space to all cells
                panel.add(button, gbc); // Add button to the panel with specified constraints
            } else {
                int adjustedIndex = i; // Initialize adjustedIndex with the current index
                if (i > 7) { // If index is greater than 7, adjust for skipping cell 8
                    adjustedIndex--; // Decrease adjustedIndex by 1 to account for the skipped cell
                }
                gbc.gridx = (adjustedIndex % 8); // Calculate the column position
                gbc.gridy = adjustedIndex / 8; // Calculate the row position
                gbc.gridwidth = 1; // Span only 1 column
                gbc.gridheight = 1; // Span only 1 row
                gbc.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
                gbc.weightx = 1.0; // Give equal horizontal space to all cells
                gbc.weighty = 1.0; // Give equal vertical space to all cells
                panel.add(button, gbc); // Add button to the panel with specified constraints

                // Store reference to button for later use
                if (i < 7) {
                    buttons[i - 1] = button;
                } else if (i > 7) {
                    buttons[i - 2] = button;
                }
            }
        }
    }

    public JPanel getPanel() {
        return panel; // Return the panel containing the gameboard
    }

    // Additional methods to update the stone count on a button
    public void updateButtonStoneCount(int index, int stones) {
        if (index < 0 || index >= buttons.length) return; // Ensure index is within bounds

        JButton button = buttons[index];
        button.setText(String.valueOf(stones));
    }
}