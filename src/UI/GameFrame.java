package UI;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    private final JFrame frame;
    private final GameBoardPanel gameBoardPanel;
    private final CommandPanel commandPanel;
    private final ScorePanel scorePanelP1;
    private final ScorePanel scorePanelP2;

    public GameFrame() {
        frame = new JFrame("Game GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        TitlePanel titlePanel = new TitlePanel();
        commandPanel = new CommandPanel();
        gameBoardPanel = new GameBoardPanel(this); // Pass reference to GameFrame
        scorePanelP1 = new ScorePanel("Player 1");
        scorePanelP2 = new ScorePanel("Player 2");

        frame.add(titlePanel.getPanel(), BorderLayout.NORTH);
        frame.add(gameBoardPanel.getPanel(), BorderLayout.CENTER);
        frame.add(commandPanel.getPanel(), BorderLayout.SOUTH);
        frame.add(scorePanelP1.getPanel(), BorderLayout.WEST);
        frame.add(scorePanelP2.getPanel(), BorderLayout.EAST);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void setCommandText(String text) {
        commandPanel.setCommandText(text);
    }

    public void updateP1Score(int score) {
        scorePanelP1.updateScore(score);
    }

    public void updateP2Score(int score) {
        scorePanelP2.updateScore(score);
    }

    public void updateButtonStoneCount(int index, int stones) {
        gameBoardPanel.updateButtonStoneCount(index, stones);
    }
}

