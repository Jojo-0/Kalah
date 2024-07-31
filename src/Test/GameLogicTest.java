package Test;

import GameData.GameLogic;
import Test.Setup.ITestResult;
import Test.Setup.Test;

public class GameLogicTest {
    public static void main(String[] args) {
        GameLogic gameLogic = getGameLogic();

        gameLogic.setPlayerOneTurn(true);

        // Simulate move
        int startIndex = 4; // Starting index
        try {
            gameLogic.makeMove(startIndex);
            resolve.returnResult(true);
        } catch (Exception e) {
            resolve.returnResult(false);
        }
    }

    private static GameLogic getGameLogic() {
        GameLogic gameLogic = new GameLogic();

        // Custom initial state
        gameLogic.setStones(0, 2); // Player 1 Base
        gameLogic.setStones(1, 0);
        gameLogic.setStones(2, 4);
        gameLogic.setStones(3, 4);
        gameLogic.setStones(4, 4);
        gameLogic.setStones(5, 4);
        gameLogic.setStones(6, 4); // End of Player 1's side
        gameLogic.setStones(7, 3); // Player 2 Base
        gameLogic.setStones(8, 4);
        gameLogic.setStones(9, 4);
        gameLogic.setStones(10, 4);
        gameLogic.setStones(11, 0);
        gameLogic.setStones(12, 0);
        gameLogic.setStones(13, 5); // End of Player 2's side
        return gameLogic;
    }

}

