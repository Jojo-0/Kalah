package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
    final GameFrame gameFrame;
    public GameActionListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        gameFrame.setCommandText("Command for " + button.getText());
    }
}
