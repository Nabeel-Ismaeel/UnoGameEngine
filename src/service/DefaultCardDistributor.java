package service;

import game.GameManager;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class DefaultCardDistributor implements CardDistributor {
    int numberOfCards;

    public DefaultCardDistributor() {
        this.numberOfCards = 7;
    }

    @Override
    public void distributeCard(GameManager gameManager) throws Exception {
        List<Player> players = gameManager.getPlayersHolder().getPlayers();
        if (players.isEmpty()) {
            throw new Exception("No players found");
        }
        for (Player player : players) {
            player.setHand(new ArrayList<>());
            for (int i = 0; i < numberOfCards; i++) {
                player.addCard(gameManager.getDrawPile().drawCard());
            }
        }
    }
}
