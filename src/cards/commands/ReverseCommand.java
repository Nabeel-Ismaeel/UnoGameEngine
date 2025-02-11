package cards.commands;

import game.GameManager;
import service.Reverser;

public class ReverseCommand implements Command {
    private Reverser reverser;

    public ReverseCommand(Reverser reverser) {
        this.reverser = reverser;
    }

    @Override
    public void execute(GameManager gameManager) throws Exception {
        reverser.reverse(gameManager);
    }
}
