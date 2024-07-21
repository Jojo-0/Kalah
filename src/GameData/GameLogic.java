package GameData;

public class GameLogic{
    private final int[] stones;
    private int scoreP1;
    private int scoreP2;
    private boolean playerOneTurn;

    public GameLogic() {
        stones = new int[12];
        for (int i = 0; i < 12; i++) {
            if (i != 0 && i !=7) {
                stones[i] = 4; // Initial 4 stones in each cell except the bases
            }
        }
        scoreP1 = 0;
        scoreP2 = 0;
        playerOneTurn = true;
    }

    public int getStones(int index) {
        return stones[index];
    }

    public int getScoreP1() {
        return scoreP1;
    }

    public int getScoreP2() {
        return scoreP2;
    }

    public boolean isPlayerOneTurn() {
        return playerOneTurn;
    }

    public void makeMove(int startIndex) {
        if (startIndex == 0 || startIndex == 7) {
            return; // Cannot start from a base
        }
        if ((playerOneTurn && startIndex > 6) || (!playerOneTurn && startIndex < 6)) {
            return; // Ensure player only picks from their own squares
        }

        int stonesInHand = stones[startIndex];
        stones[startIndex] = 0;

        int index = startIndex;
        while (stonesInHand > 0) {
            index = (index + 1) % 12;
            if ((playerOneTurn && index == 7) || (!playerOneTurn && index == 0)) {
                continue; // Skip the opponent's base
            }
            stones[index]++;
            stonesInHand--;
        }

        // Switch turns
        playerOneTurn = !playerOneTurn;
    }

    public void updateScores() {
        scoreP1 = stones[0];
        scoreP2 = stones[7];
    }
}




