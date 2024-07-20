package UI;

import javax.swing.*;
import java.awt.*;

public class ScorePanel {
    private JPanel panel;
    private JLabel scoreLabel;
    private int score = 0;

    public ScorePanel(String label) {
        panel = new JPanel(new GridLayout(2, 1)); // Two rows, one for the label and one for the score
        scoreLabel = new JLabel( "score: "+ score, SwingConstants.CENTER);

        panel.add(new JLabel(label, SwingConstants.CENTER)); // Add label for player
        panel.add(scoreLabel); // Add label for score
    }

    public JPanel getPanel() {
        return panel; // Return the panel containing the score labels
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }
}
