package service;

import cards.Card;
import cards.NumberCard;
import cards.Type;

import java.util.List;

public class DefaultCardMatcher implements CardMatcher {

    @Override
    public boolean isMatch(Card lastDrawnCard, Card newCard) {
        if (newCard.getType() == Type.Wild || newCard.getType() == Type.WildDrawFour) {
            return true;
        }
        if (lastDrawnCard.getColor() == newCard.getColor()) {
            return true;
        }
        if (lastDrawnCard instanceof NumberCard && newCard instanceof NumberCard) {
            return ((NumberCard) lastDrawnCard).getNumber() == ((NumberCard) newCard).getNumber();
        }
        return lastDrawnCard.getType() == newCard.getType();
    }

    @Override
    public boolean anyMatch(Card lastDrawnCard, List<Card> cards) {
        return cards.stream()
                .anyMatch(card -> isMatch(lastDrawnCard , card));
    }
}
