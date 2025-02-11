package cards.commands;

import game.GameManager;
import service.CardDrawer;
import service.ColorChanger;

public class WildDrawCommand implements Command {
    private CardDrawer cardDrawer;
    private ColorChanger colorChanger;

    public WildDrawCommand(CardDrawer cardDrawer, ColorChanger colorChanger) {
        this.cardDrawer = cardDrawer;
        this.colorChanger = colorChanger;
    }

    @Override
    public void execute(GameManager gameManager) throws Exception {
        colorChanger.changeColor(gameManager);
        cardDrawer.nextPlayerDraw(gameManager, 4);
    }
}
