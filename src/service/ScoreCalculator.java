package service;

import game.GameManager;
import player.Player;

public interface ScoreCalculator {
    void calculateScore(GameManager gameManager);

    Player getTopPlayer(GameManager gameManager);
}
