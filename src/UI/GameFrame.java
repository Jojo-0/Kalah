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
    private final Color Gamebackground = new Color(238,216,174);
    public GameFrame() {
        frame = new JFrame("Das Bohnenspiel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setBackground(new Color(238,216,174));//238,216,174
        //frame.setBackground(Color.BLACK);

        gameLogic = new GameLogic();
        titlePanel = new TitlePanel();
        commandPanel = new CommandPanel();
        gameBoardPanel = new GameBoardPanel(this);
        scorePanelP1 = new ScorePanel("Player 1");
        scorePanelP2 = new ScorePanel("Player 2");

        setGamebackground(titlePanel.getPanel());
        setGamebackground(commandPanel.getPanel());
        setGamebackground(scorePanelP1.getPanel());
        setGamebackground(scorePanelP2.getPanel());

        // Set preferred sizes for the panels
        titlePanel.getPanel().setPreferredSize(new Dimension(800, 130)); // Height 100 for the North region
        commandPanel.getPanel().setPreferredSize(new Dimension(800, 100)); // Height 50 for the South region
        scorePanelP1.getPanel().setPreferredSize(new Dimension(170, 600)); // Width 150 for the West region
        scorePanelP2.getPanel().setPreferredSize(new Dimension(170, 600)); // Width 150 for the East region


        //Add panels to the frame
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

    private void setGamebackground(JPanel panel) {
        panel.setBackground(Gamebackground);
    }

    public void setCommandText(String text) {
        commandPanel.setCommandText(text);
    }

    public void updateUI() {
        for (int i = 0; i < 14; i++) {
            gameBoardPanel.updateButtonStoneCount(i, gameLogic.getStones(i));
        }

        scorePanelP1.updateScore(gameLogic.getScoreP1());
        scorePanelP2.updateScore(gameLogic.getScoreP2());
    }

    public void makeMove(int index) {
        gameLogic.makeMove(index);
        //gameLogic.updateScores();
        updateUI();
    }

    public GameBoardPanel getGameBoardPanel() {
        return gameBoardPanel;
    }
}

// background: wheat2 (#EED8AE); Player one: Forestgreen(#228B22); Player 2: red4(#8b0000)