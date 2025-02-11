package pile;

import cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultPileManager implements PileManager {
    private List<Card> cards;

    public DefaultPileManager() {
        this.cards = new ArrayList<>();
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public Card drawCard() throws Exception {
        if (cards.isEmpty()) {
            throw new IllegalAccessException("the pile is empty");
        }
        return cards.removeLast();
    }

    @Override
    public int getPileSize() {
        return cards.size();
    }

    @Override
    public void merge(PileManager other) throws Exception {
        Card lastCard = other.drawCard();
        cards.addAll(other.getPile());
        other.clear();
        other.addCard(lastCard);
        Collections.shuffle(cards);
    }

    @Override
    public void clear() {
        cards.clear();
    }

    @Override
    public List<Card> getPile() {
        return cards;
    }

    @Override
    public void setPile(List<Card> pile) {
        this.cards = pile;
    }

    @Override
    public Card getLastCard() {
        return cards.getLast();
    }
}
