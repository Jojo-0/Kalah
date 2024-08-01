package Test;

import GameData.GameLogic;
import Test.Setup.ITestResult;
import Test.Setup.Test;

public class GameLogicTest {
    @Test(name = "moveEndsInBase", order = 0)
    public void moveEndsInBase(ITestResult resolve) {
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

    @Test(name= "StoneLandsInEmptyField", order = 2)
    public void StoneLandsInEmptyField(ITestResult resolve) {
        GameLogic gameLogic = getGameLogic();
        gameLogic.setPlayerOneTurn(true);
        int startIndex = 5;
        try {
            gameLogic.makeMove(startIndex);
            resolve.returnResult(true);
        } catch (Exception e) {
            resolve.returnResult(false);
        }
    }

    @Test(name = "WinnerP1Scenario", order = 3)
    public void WinnerP1Scenario(ITestResult resolve) {
        GameLogic gameLogic = getGameLogic();
        try {
            if (gameLogic.isGameOver()) {
                String winner = gameLogic.getWinner();
                resolve.returnResult("P1 wins with 20 points!".equals(winner));
            } else {
                resolve.returnResult(false);
            }
        } catch (Exception e) {
            resolve.returnResult(false);
        }
    }

    @Test(name = "ItsADraw", order = 3)
    public void ItsADraw(ITestResult resolve) {
        GameLogic gameLogic = getGameLogicDraw();

        try {
            if (gameLogic.isGameOver()) {
                String winner = gameLogic.getWinner();
                resolve.returnResult("Draw".equals(winner));
            } else {
                resolve.returnResult(false);
            }
        }
        catch (Exception e) {
        resolve.returnResult(false);
        }
    }

    private static GameLogic getGameLogic() {
        GameLogic gameLogic = new GameLogic();

        // Custom initial state
        gameLogic.setStones(0, 20); // Player 1 Base
        gameLogic.setStones(1, 0);
        gameLogic.setStones(2, 0);
        gameLogic.setStones(3, 0);
        gameLogic.setStones(4, 0);
        gameLogic.setStones(5, 0);
        gameLogic.setStones(6, 0); // End of Player 1's side
        gameLogic.setStones(7, 10); // Player 2 Base
        gameLogic.setStones(8, 0);
        gameLogic.setStones(9, 0);
        gameLogic.setStones(10, 0);
        gameLogic.setStones(11, 0);
        gameLogic.setStones(12, 0);
        gameLogic.setStones(13, 0);

        gameLogic.updateScores();// End of Player 2's side
        return gameLogic;
    }

    private static GameLogic getGameLogicDraw() {
        GameLogic gameLogic = new GameLogic();

        // Custom initial state
        gameLogic.setStones(0, 20); // Player 1 Base
        gameLogic.setStones(1, 0);
        gameLogic.setStones(2, 0);
        gameLogic.setStones(3, 0);
        gameLogic.setStones(4, 0);
        gameLogic.setStones(5, 0);
        gameLogic.setStones(6, 0); // End of Player 1's side
        gameLogic.setStones(7, 20); // Player 2 Base
        gameLogic.setStones(8, 0);
        gameLogic.setStones(9, 0);
        gameLogic.setStones(10, 0);
        gameLogic.setStones(11, 0);
        gameLogic.setStones(12, 0);
        gameLogic.setStones(13, 0);

        gameLogic.updateScores();// End of Player 2's side
        return gameLogic;
    }

}

