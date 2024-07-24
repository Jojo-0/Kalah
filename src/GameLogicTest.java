package GameData;

public class GameLogicTest {
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();

        // Set up a custom scenario
        gameLogic.setStones(0, 0);  // Base of player 1
        gameLogic.setStones(1, 1);
        gameLogic.setStones(2, 0);
        gameLogic.setStones(3, 0);
        gameLogic.setStones(4, 0);
        gameLogic.setStones(5, 0);
        gameLogic.setStones(6, 4);
        gameLogic.setStones(7, 0);  // Base of player 2
        gameLogic.setStones(8, 0);
        gameLogic.setStones(9, 4);
        gameLogic.setStones(10, 4);
        gameLogic.setStones(11, 4);
        gameLogic.setStones(12, 4);
        gameLogic.setStones(13, 4);

        gameLogic.setScoreP1(0);
        gameLogic.setScoreP2(0);
        gameLogic.setPlayerOneTurn(true);

        // Print initial state
        printGameState(gameLogic);

        // Player 1 makes a move from cell 1
        gameLogic.makeMove(1);

        // Print state after the move
        printGameState(gameLogic);
    }

    private static void printGameState(GameLogic gameLogic) {
        System.out.println("Current State:");
        for (int i = 0; i < 14; i++) {
            System.out.print("Cell " + i + ": " + gameLogic.getStones(i) + " | ");
        }
        System.out.println();
        System.out.println("Player 1 Score: " + gameLogic.getScoreP1());
        System.out.println("Player 2 Score: " + gameLogic.getScoreP2());
        System.out.println("Player One's Turn: " + gameLogic.isPlayerOneTurn());
        System.out.println("-------------------------------");
    }
}
