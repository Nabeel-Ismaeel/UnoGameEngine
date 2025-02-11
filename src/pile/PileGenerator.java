package pile;

import game.GameManager;

public interface PileGenerator {
    void generate(GameManager gameManager) throws Exception;
}
