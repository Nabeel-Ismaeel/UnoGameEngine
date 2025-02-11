package player;

import java.util.List;

public interface PlayersHolder {
    void movePlayer();

    Player getNextPlayer();

    void changeDirection();

    List<Player> getPlayers();

    Player getCurrentPlayer();

    Player getPlayer(int index);

    void addPlayer(Player player);
}
