package service;

import cards.Card;
import game.GameManager;
import player.Player;

import java.util.Comparator;
import java.util.List;

public class DefaultScoreCalculator implements ScoreCalculator {

    @Override
    public void calculateScore(GameManager gameManager) {
        List<Player> players = gameManager.getPlayersHolder().getPlayers();
        for (Player player : players) {
            player.setScore(player.getScore() + player.getHand()
                    .stream()
                    .mapToInt(Card::getPoints)
                    .sum());
        }
    }

    @Override
    public Player getTopPlayer(GameManager gameManager) {
        List<Player> players = gameManager.getPlayersHolder().getPlayers();
        return players.stream()
                .min(Comparator.comparingInt(Player::getScore))
                .orElse(players.get(0));
    }

}
