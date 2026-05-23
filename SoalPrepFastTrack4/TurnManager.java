package SoalPrepFastTrack4;

import java.util.ArrayList;
import java.util.List;

public class TurnManager {

    private int currentIndex;
    private List<Player> players;

    public TurnManager(List<Player> players) {
        this.currentIndex = 0;
        this.players = new ArrayList<>(players);
    }

    public Player getCurrentPlayer() {
        return this.players.get(currentIndex);
    }

    public void nextTurn() {
        this.currentIndex = (this.currentIndex + 1) % this.players.size();
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public Player peekNextPlayer() {
        int nextIndex = (this.currentIndex + 1) % this.players.size();
        return this.players.get(nextIndex);
    }
    
}
