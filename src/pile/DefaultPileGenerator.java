package pile;

import cards.*;
import cards.commands.*;
import game.GameManager;
import service.DefaultCardDrawer;
import service.DefaultColorChanger;
import service.DefaultReverser;
import service.DefaultSkipper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultPileGenerator implements PileGenerator {
    private List<Card> cards;
    private static DefaultPileGenerator defaultPileGenerator = new DefaultPileGenerator();

    private DefaultPileGenerator() {
        cards = new ArrayList<>();
    }

    public static DefaultPileGenerator getInstance() {
        return defaultPileGenerator;
    }

    @Override
    public void generate(GameManager gameManager) throws Exception {
        if (!cards.isEmpty()) {
            List<Card> newCards = new ArrayList<>(cards);
            Collections.shuffle(newCards);
            gameManager.getDrawPile().setPile(newCards);
            gameManager.getDiscardPile().clear();
            gameManager.getDiscardPile().addCard(gameManager.getDrawPile().drawCard());
        }
        for (int i = 0; i <= 1; i++) {
            for (Color color : Color.values()) {
                if (color != Color.Wield) {
                    for (int j = i; j <= 9; j++) {
                        cards.add(new NumberCard(j, color, Type.Number, j));
                    }
                    cards.add(new SkipCard(10, color, Type.Skip, new SkipCommand(new DefaultSkipper())));
                    cards.add(new ReverseCard(10, color, Type.Reverse, new ReverseCommand(new DefaultReverser())));
                    cards.add(new DrawTwoCard(10, color, Type.DrawTwo, new DrawTwoCommand(new DefaultCardDrawer())));
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard(10, Color.Wield, Type.Wild, new WildCommand(new DefaultColorChanger())));
            cards.add(new WildDrawCard(10, Color.Wield, Type.WildDrawFour, new WildDrawCommand(new DefaultCardDrawer(), new DefaultColorChanger())));
        }

        List<Card> newCards = new ArrayList<>(cards);
        Collections.shuffle(newCards);
        gameManager.getDiscardPile().clear();
        gameManager.getDrawPile().setPile(newCards);
        gameManager.getDiscardPile().addCard(gameManager.getDrawPile().drawCard());
    }
}
