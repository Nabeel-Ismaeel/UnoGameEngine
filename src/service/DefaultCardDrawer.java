package service;

import cards.Card;
import game.GameManager;

public class DefaultCardDrawer implements CardDrawer {

    @Override
    public void drawCard(GameManager gameManager) throws Exception {
        Card card = gameManager.getDrawPile().drawCard();
        gameManager.getPlayersHolder().getCurrentPlayer().addCard(card);
    }

    @Override
    public void nextPlayerDraw(GameManager gameManager, int numberOfCard) throws Exception {
        for (int i = 0; i < numberOfCard; i++) {
            Card card = gameManager.getDrawPile().drawCard();
            gameManager.getPlayersHolder().getNextPlayer().addCard(card);
        }
    }
}

