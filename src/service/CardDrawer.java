package service;

import game.GameManager;

public interface CardDrawer {
    void drawCard(GameManager gameManager) throws Exception;

    void nextPlayerDraw(GameManager gameManager, int numberOfCard) throws Exception;
}
