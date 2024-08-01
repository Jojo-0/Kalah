package UI;

import GameData.GameLogic;

public interface GameGui {
    void updateUI();
    void setCommandText(String text);
    void makeMove(int index);
    void displayWinner(String winner);
    void updateTurnMessage();
    GameLogic getGameLogic();
    //GameBoardPanel getGameBoardPanel();
}
