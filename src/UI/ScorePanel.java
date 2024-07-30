package UI;

import javax.swing.*;
import java.awt.*;

public class ScorePanel {
    private final JPanel panel;
    private final JLabel scoreLabel;

    public ScorePanel(String playerName) {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //panel.setLayout(new GridBagLayout());
        JLabel label = new JLabel(playerName);
        label.setFont(new Font("Serif", Font.PLAIN, 18)); // Increase the font size
        scoreLabel = new JLabel("0"); // Initial score is 0
        label.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);
        panel.add(scoreLabel, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Center the label



    }

    public JPanel getPanel() {
        return panel; // Return the panel containing the score labels
    }

    public void updateScore(int score) {
        scoreLabel.setText(String.valueOf(score));
    }
}
