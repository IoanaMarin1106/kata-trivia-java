package trivia;

public class GameConfiguration {

    private final int[] places = new int[6];
    private final int[] purses = new int[6];
    private final boolean[] inPenaltyBox = new boolean[6];

    public int getPlaces(int player) {
        return places[player];
    }

    public boolean getInPenaltyBox(int player) {
        return inPenaltyBox[player];
    }

    public void setPlaces(int player, int value) {
        places[player] = value;
    }

    public void setPursues(int player, int value) {
        purses[player] = value;
    }

    public void setInPenaltyBox(int player, boolean value) {
        inPenaltyBox[player] = value;
    }

    public void setPlayerPlace(int currentPlayer, int roll) {
        places[currentPlayer] = ((places[currentPlayer] + roll) > 11) ?
                                        ((places[currentPlayer] + roll) - 12) :
                                        (places[currentPlayer] + roll);
    }

    public void addNewPlayerConfig(int playersNum) {
        places[playersNum] = 0;
        purses[playersNum] = 0;
        inPenaltyBox[playersNum] = false;
    }

    public boolean incrementGoldCoins(int player, String playerName) {
        purses[player]++;

        System.out.println(playerName
                + " now has "
                + purses[player]
                + " Gold Coins.");

        return (purses[player] != 6);
    }
}
