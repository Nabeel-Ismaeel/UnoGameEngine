package service;

import game.GameManager;

public class DefaultSkipper implements Skipper {
    @Override
    public void skip(GameManager gameManager) {
        gameManager.getPlayersHolder().movePlayer();
    }
}
