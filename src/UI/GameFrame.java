package UI;
import GameData.GameLogic;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    private final JFrame frame;
    private final TitlePanel titlePanel;
    private final GameBoardPanel gameBoardPanel;
    private final CommandPanel commandPanel;
    private final ScorePanel scorePanelP1;
    private final ScorePanel scorePanelP2;
    private final GameLogic gameLogic;

    public GameFrame() {
        gameLogic = new GameLogic();

        frame = new JFrame("Game GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        titlePanel = new TitlePanel();
        commandPanel = new CommandPanel();
        gameBoardPanel = new GameBoardPanel(this);
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
        updateUI();
    }

    public void setCommandText(String text) {
        commandPanel.setCommandText(text);
    }

    public void updateUI() {
        for (int i = 0; i < 12; i++) {
            gameBoardPanel.updateButtonStoneCount(i, gameLogic.getStones(i));
        }
        gameBoardPanel.updateBaseStoneCount(0, gameLogic.getScoreP1());
        gameBoardPanel.updateBaseStoneCount(7, gameLogic.getScoreP2());
        scorePanelP1.updateScore(gameLogic.getScoreP1());
        scorePanelP2.updateScore(gameLogic.getScoreP2());
    }

    public void makeMove(int index) {
        gameLogic.makeMove(index);
        gameLogic.updateScores();
        updateUI();
    }

    public GameBoardPanel getGameBoardPanel() {
        return gameBoardPanel;
    }
}

