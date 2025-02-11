package pile;

import cards.Card;

import java.util.List;

public interface PileManager {
    void clear();

    int getPileSize();

    Card getLastCard();

    List<Card> getPile();

    void addCard(Card card);

    void setPile(List<Card> pile);

    void merge(PileManager other) throws Exception;

    Card drawCard() throws Exception;
}
