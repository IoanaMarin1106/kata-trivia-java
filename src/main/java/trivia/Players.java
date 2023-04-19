package trivia;

import java.util.ArrayList;

public class Players {

    private final ArrayList<String> players;
    private int currentPlayer;

    public Players() {
        this.players = new ArrayList<>();
        this.currentPlayer = 0;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public String getCurrentPlayerName() {
        return players.get(currentPlayer);
    }

    public int getCapacity() {
        return players.size();
    }

    public void incrementCurrentPlayer() {
        currentPlayer += 1;
        currentPlayer = (currentPlayer == players.size()) ? 0 : currentPlayer;
    }

    public void addPlayer(String playerName) {
        players.add(playerName);
    }

    public boolean isPlayable() {
        return (players.size() >= 2);
    }

}
