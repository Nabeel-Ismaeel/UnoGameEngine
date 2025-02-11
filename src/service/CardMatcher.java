package service;

import cards.Card;

import java.util.List;

public interface CardMatcher {
    boolean isMatch(Card lastDrawnCard, Card newCard);

    boolean anyMatch(Card lastDrawnCard, List<Card> cards);
}
