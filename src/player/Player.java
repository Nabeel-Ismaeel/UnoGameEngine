package player;

import cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Integer age;
    private Integer score;
    private List<Card> hand;

    public Player(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.score = 0;
        this.hand = new ArrayList<Card>();
    }

    public Player(PlayerBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.score = builder.score;
        this.hand = builder.hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public Card playCard(int index) {
        return hand.remove(index);
    }

    public static class PlayerBuilder {
        private final String name;
        private Integer age;
        private Integer score;
        private List<Card> hand;

        public PlayerBuilder(String name) {
            this.name = name;
        }

        public PlayerBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public PlayerBuilder score(Integer score) {
            this.score = score;
            return this;
        }

        public PlayerBuilder hand(List<Card> cards) {
            this.hand = cards;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }

}
