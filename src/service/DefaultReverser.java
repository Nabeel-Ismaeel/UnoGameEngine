package service;

import game.GameManager;

public class DefaultReverser implements Reverser {
    public void reverse(GameManager gameManager) {
        gameManager.getPlayersHolder().changeDirection();
    }
}
