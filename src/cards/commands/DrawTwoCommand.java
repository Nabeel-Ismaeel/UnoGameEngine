package cards.commands;

import game.GameManager;
import service.CardDrawer;

public class DrawTwoCommand implements Command {
    private CardDrawer cardDrawer;

    public DrawTwoCommand(CardDrawer cardDrawer) {
        this.cardDrawer = cardDrawer;
    }

    @Override
    public void execute(GameManager gameManager) throws Exception {
        cardDrawer.nextPlayerDraw(gameManager, 2);
    }
}
