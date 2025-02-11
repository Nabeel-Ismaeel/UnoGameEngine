package cards.commands;

import game.GameManager;
import service.Skipper;

public class SkipCommand implements Command {
    private Skipper skipper;

    public SkipCommand(Skipper skipper) {
        this.skipper = skipper;
    }

    @Override
    public void execute(GameManager gameManager) throws Exception {
        skipper.skip(gameManager);
    }
}
