package player;

import java.util.ArrayList;
import java.util.List;

public class DefaultPlayersHolder implements PlayersHolder {
    private int index;
    private int direction;
    private List<Player> players;

    public DefaultPlayersHolder() {
        this.index = 0;
        this.direction = 1;
        this.players = new ArrayList<>();
    }

    @Override
    public Player getNextPlayer() {
        return players.get((index + direction + players.size()) % players.size());
    }

    @Override
    public void changeDirection() {
        direction *= -1;
    }

    @Override
    public Player getCurrentPlayer() {
        return players.get(index % players.size());
    }

    @Override
    public Player getPlayer(int index) {
        return players.get(index);
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void movePlayer() {
        index = (index + direction + players.size()) % players.size();
    }
}
