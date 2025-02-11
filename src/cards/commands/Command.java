package cards.commands;

import game.GameManager;

public interface Command {
    void execute(GameManager gameManager) throws Exception;
}
