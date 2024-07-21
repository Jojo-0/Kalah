package UI;

import javax.swing.*;
import java.awt.*;

public class ScorePanel {
    private final JPanel panel;
    private final JLabel scoreLabel;

    public ScorePanel(String playerName) {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel(playerName);
        scoreLabel = new JLabel("0"); // Initial score is 0
        panel.add(label, BorderLayout.NORTH);
        panel.add(scoreLabel, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel; // Return the panel containing the score labels
    }

    public void updateScore(int score) {
        scoreLabel.setText(String.valueOf(score));
    }
}
