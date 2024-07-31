package GameData;

public class GameLogic {
    private final int[] stones;
    private int scoreP1;
    private int scoreP2;
    private boolean playerOneTurn;

    public GameLogic() {
        stones = new int[14]; // Including the bases at index 0 and 7
        for (int i = 0; i < 14; i++) {
            if (i != 0 && i != 7) {
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

    /*public boolean isPlayerOneTurn() {
        return playerOneTurn;
    }*/

    public void makeMove(int startIndex) {
        if (!isValidMove(startIndex)) {
            return; // Cannot start from a base
        }

        int stonesInHand = stones[startIndex];
        stones[startIndex] = 0;
        int index = startIndex;

        while (stonesInHand > 0) {
            index = (index - 1 + 14) % 14; // Move counterclockwise
            if (isOpponentBase(index)) {
                continue; // Skip the opponent's base
            }
            stones[index]++;
            stonesInHand--;
        }

        applyEmptyCellRule(index);
        final boolean isDoubleMove = applyLandedInBaseRule(index);

        if (!isGameOver()) {
            if (!isDoubleMove) {
                playerOneTurn = !playerOneTurn; // Switch turns only if game is not over
            }
        } else {
            collectRemainingStones();
        }
        updateScores();
    }

    private boolean isValidMove(int startIndex) {
        if (startIndex == 0 || startIndex == 7) {
            return false;
        }
        return (playerOneTurn && startIndex < 7) || (!playerOneTurn && startIndex > 7);
    }

    private boolean isOpponentBase(int index) {
        return (playerOneTurn && index == 7) || (!playerOneTurn && index == 0);
    }

    private void applyEmptyCellRule(int index) {
        if (index == 0 || index == 7) {
            return; // don't apply rule to bases
        }
        boolean lastStoneInEmptyOwnCell = stones[index] == 1 && ((playerOneTurn && index <7 && index !=0) || (!playerOneTurn && index >7));
        int oppositeIndex = 14 - index;
        boolean oppositeCellFull = stones[oppositeIndex] > 0;

        if (lastStoneInEmptyOwnCell && oppositeCellFull) {

            if (playerOneTurn){
                stones[0] += stones[oppositeIndex];
            } else {
                stones[7] += stones[oppositeIndex];
            }
            stones[oppositeIndex] = 0;
        }

    }

        // Player gets another turn, if the last stone lands in their base
    private boolean applyLandedInBaseRule(int index){
        boolean landedInOwnBase = (playerOneTurn && index == 0) || (!playerOneTurn && index == 7);
        return landedInOwnBase;
    }

    public boolean isGameOver() {
        boolean playerOneEmpty = true;
        boolean playerTwoEmpty = true;

        for (int i = 1; i < 7; i++) {
            if (stones[i] > 0) {
                playerOneEmpty = false;
            }
            if (stones[i + 7] > 0) {
                playerTwoEmpty = false;
            }
        }
        return playerOneEmpty || playerTwoEmpty;
    }

    private void collectRemainingStones(){
        for (int i = 1; i < 7; i++) {
            scoreP1 += stones[i];
            stones[i] = 0;
            scoreP2 += stones[i+7];
            stones[i+7] = 0;
        }
    }

    public String getWinner(){
        if(isGameOver()){
            collectRemainingStones();
            if (scoreP1 > scoreP2) {
                return "P1 wins with " + scoreP1 + " point!";
            }
            else if (scoreP1 < scoreP2) {
                return "P2 wins with " + scoreP2 + " point!";
            }
            else {
                return "Draw";
            }

        }
        return "";

    }

   public void updateScores() {
        scoreP1 = stones[0];
        scoreP2 = stones[7];
    }
    //Setter methods for testing
    public void setStones(int index, int count) {
        stones[index] = count;
    }

    public void setPlayerOneTurn(boolean playerOneTurn) {
        this.playerOneTurn = playerOneTurn;
    }


}




