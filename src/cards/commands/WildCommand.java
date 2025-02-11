package cards.commands;

import game.GameManager;
import service.ColorChanger;

public class WildCommand implements Command {
    private ColorChanger colorChanger;

    public WildCommand(ColorChanger colorChanger) {
        this.colorChanger = colorChanger;
    }

    @Override
    public void execute(GameManager gameManager) {
        colorChanger.changeColor(gameManager);
    }
}
