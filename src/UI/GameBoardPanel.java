package UI;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel {
    private JPanel panel;

    public GameBoardPanel(GameFrame gameFrame) { // Accept reference to GameFrame
        panel = new JPanel(new GridBagLayout()); // Use GridBagLayout for flexible grid-based layout
        GridBagConstraints gbc = new GridBagConstraints(); // Define constraints for GridBagLayout

        // Define the buttons for the gameboard
        for (int i = 0; i < 16; i++) { // Loop through 16 cells
            String buttonLabel;
            if (i == 0 || i == 7) {
                buttonLabel = "Base"; // Label cell 1 and cell 8 as "Base"
            } else if (i < 8) {
                buttonLabel = "P1 Cell " + i; // Label cells 1 to 7 for player 1
            } else {
                buttonLabel = "P2 Cell " + (i - 8); // Label cells 9 to 16 for player 2
            }

            JButton button = new JButton(buttonLabel); // Create a button with the appropriate label
            button.addActionListener(new GameActionListener(gameFrame)); // Add action listener to the button

            if (i == 0) { // First button, span 2 rows
                gbc.gridx = 0; // Position at the first column
                gbc.gridy = 0; // Position at the first row
                gbc.gridwidth = 1; // Span only 1 column
                gbc.gridheight = 2; // Span 2 rows
            } else if (i == 7) { // Last button in the first row, span 2 rows
                gbc.gridx = 7; // Position at the eighth column
                gbc.gridy = 0; // Position at the first row
                gbc.gridwidth = 1; // Span only 1 column
                gbc.gridheight = 2; // Span 2 rows
            } else if (i == 8) { // Skip the 9th button
                continue; // Continue to the next iteration without adding the button
            } else {
                int adjustedIndex = i; // Initialize adjustedIndex with the current index
                if (i > 7) { // If index is greater than 7, adjust for skipping cell 8
                    adjustedIndex--; // Decrease adjustedIndex by 1 to account for the skipped cell
                }
                gbc.gridx = (adjustedIndex % 8); // Calculate the column position
                gbc.gridy = adjustedIndex / 8; // Calculate the row position
                if (adjustedIndex > 7) { // If adjustedIndex is greater than 7
                    gbc.gridx++; // Increment the column position by 1
                }
                gbc.gridwidth = 1; // Span only 1 column
                gbc.gridheight = 1; // Span only 1 row
            }

            gbc.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
            gbc.weightx = 1.0; // Give equal horizontal space to all cells
            gbc.weighty = 1.0; // Give equal vertical space to all cells

            panel.add(button, gbc); // Add button to the panel with specified constraints
        }
    }

    public JPanel getPanel() {
        return panel; // Return the panel containing the gameboard
    }
}
