package cards.commands;

import game.GameManager;

public class NoOpCommand implements Command {
    @Override
    public void execute(GameManager gameManager) throws Exception {

    }
}
