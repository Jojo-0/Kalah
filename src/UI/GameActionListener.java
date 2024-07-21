package UI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
    private final GameFrame gameFrame;

    public GameActionListener(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int index = -1;

        //Find the index of the button
        for(int i = 0; i < gameFrame.getGameBoardPanel().getButtons().length;i++) {
            if (gameFrame.getGameBoardPanel().getButtons()[i].equals(button)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            //Ensures the move is not started from a Base
            if (index == 0 || index == 7){
                gameFrame.setCommandText("Cannot start from a base!");
            } else {
                gameFrame.makeMove(index);
            }
        }
    }
}



