package UI;

public interface GameGui {
    void updateUI();
    void setCommandText(String text);
    void makeMove(int index);
    void displayWinner(String winner);
}
