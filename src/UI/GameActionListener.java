package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
    private GameFrame gameFrame;

    public GameActionListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        gameFrame.setCommandText("Command for " + button.getText());

        // For demonstration purposes, increment scores and update stones based on button presses
        String buttonText = button.getText();
        int currentStones;
        try {
            currentStones = Integer.parseInt(buttonText);
        } catch (NumberFormatException ex) {
            // Ignore bases
            return;
        }

        // Example logic to update stone count
        int newStones = currentStones + 1;
        button.setText(String.valueOf(newStones));

        // Example logic to update scores (these should be properly handled in game logic)
        gameFrame.updateP1Score((int) (Math.random() * 100)); // Random score for player 1
        gameFrame.updateP2Score((int) (Math.random() * 100)); // Random score for player 2
    }
}



