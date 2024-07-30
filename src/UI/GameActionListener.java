package UI;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
    private final GameGui gameGui;

    public GameActionListener( GameGui gameGui) {
        this.gameGui = gameGui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        int index = findButtonIndex(button);

        if (isValidMove(index)) {
            gameGui.makeMove(index);
            checkGameOver();
        }
    }

    private int findButtonIndex(JButton button) {

        //Find the index of the button
        for(int i = 0; i < ((GameFrame) gameGui).getGameBoardPanel().getButtons().length;i++) {
            if (((GameFrame) gameGui).getGameBoardPanel().getButtons()[i].equals(button)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isValidMove(int index) {

        if (index == -1) {
            return false;
        }
        if (index == 0 || index == 7) {
            gameGui.setCommandText("Cannot start from a base!");
            return false;
        }
        return true;
    }

    private void checkGameOver() {
        if (((GameFrame) gameGui).getGameLogic().isGameOver()){
            String winner = ((GameFrame) gameGui).getGameLogic().getWinner();
            gameGui.setCommandText(winner);
        }
    }
}




