package Test;

import GameData.GameLogic;

public class GameLogicTest {
    public static void main(String[] args) {
        GameLogic gameLogic = getGameLogic();

        gameLogic.setPlayerOneTurn(true);

        // Simulate move
        int startIndex = 3; // Starting index
        gameLogic.makeMove(startIndex);

        // Print results
        System.out.println("Stones in cells after move:");
        for (int i = 0; i < 14; i++) {
            System.out.println("Cell " + i + ": " + gameLogic.getStones(i));
        }
        System.out.println("Player 1 Score: " + gameLogic.getScoreP1());
        System.out.println("Player 2 Score: " + gameLogic.getScoreP2());
    }

    private static GameLogic getGameLogic() {
        GameLogic gameLogic = new GameLogic();

        // Custom initial state
        gameLogic.setStones(0, 0); // Player 1 Base
        gameLogic.setStones(1, 0);
        gameLogic.setStones(2, 4);
        gameLogic.setStones(3, 2);
        gameLogic.setStones(4, 4);
        gameLogic.setStones(5, 4);
        gameLogic.setStones(6, 4); // End of Player 1's side
        gameLogic.setStones(7, 0); // Player 2 Base
        gameLogic.setStones(8, 4);
        gameLogic.setStones(9, 4);
        gameLogic.setStones(10, 4);
        gameLogic.setStones(11, 4);
        gameLogic.setStones(12, 4);
        gameLogic.setStones(13, 4); // End of Player 2's side
        return gameLogic;
    }

}

