package UI;

import javax.swing.*;
import java.awt.*;


public class GameFrame {
    private JFrame frame;
    private GameBoardPanel gameBoardPanel;
    private TitlePanel titlePanel;
    private CommandPanel commandPanel;

    public GameFrame() {
        initialize();
    }
    private void initialize() {
        this.frame = new JFrame();
        this.frame.setTitle("The Beansgame");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(800, 600);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setVisible(true);

        titlePanel = new TitlePanel();
        gameBoardPanel = new GameBoardPanel(this);
        commandPanel = new CommandPanel();

        this.frame.add(titlePanel.getPanel(), BorderLayout.NORTH);
        this.frame.add(gameBoardPanel.getPanel(), BorderLayout.CENTER);
        this.frame.add(commandPanel.getPanel(), BorderLayout.SOUTH);

    }
    public void setCommandText(String text) {
        commandPanel.setCommandText(text);
    }
}
