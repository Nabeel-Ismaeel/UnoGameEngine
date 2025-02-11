package game;

import service.DefaultCardDrawer;
import cards.Card;
import pile.DefaultPileGenerator;
import pile.DefaultPileManager;
import player.DefaultPlayerGenerator;
import player.DefaultPlayersHolder;
import player.Player;
import service.DefaultCardDistributor;
import service.DefaultCardMatcher;
import service.DefaultScoreCalculator;

import java.util.Scanner;

public class MyGame extends GameManager {
    private Scanner scanner = new Scanner(System.in);
    private int numberOfRounds = 2;

    private void separateLine() {
        System.out.println("______________________________________________________________________________");
    }

    private void initRound() throws Exception {
        getPileGenerator().generate(this);
        getCardDistributor().distributeCard(this);
    }

    private void finishRound() throws Exception {
        System.out.println("the winner of this round is : ");
        System.out.println(getPlayersHolder().getCurrentPlayer().getName());
        getScoreCalculator().calculateScore(this);
    }


    private void playRound() throws Exception {
        initRound();
        while (true) {
            Player currentPlayer = getPlayersHolder().getCurrentPlayer();
            Card lastCard = getDiscardPile().getLastCard();
            System.out.println("Player " + currentPlayer.getName() + "'s turn");
            System.out.println("The last played card is : " + lastCard);
            System.out.println("These are your cards:");
            System.out.println(currentPlayer.getHand());
            if (getCardMatcher().anyMatch(getDiscardPile().getLastCard(), currentPlayer.getHand())) {
                System.out.println("Enter the index of the card you would like to play:");
                int cardIndex = scanner.nextInt();
                while (true) {
                    if (0 > cardIndex || cardIndex >= currentPlayer.getHand().size()) {
                        System.out.println("Please enter a valid index of the card you would like to play (0 - " + (currentPlayer.getHand().size() - 1) + "):");
                        cardIndex = scanner.nextInt();
                    } else if (!getCardMatcher().isMatch(lastCard, currentPlayer.getHand().get(cardIndex))) {
                        System.out.println("Please enter the index of card you would like to play (must match with the last played card):");
                        cardIndex = scanner.nextInt();
                    } else {
                        break;
                    }
                }

                lastCard = currentPlayer.playCard(cardIndex);
                getDiscardPile().addCard(lastCard);

                if (currentPlayer.getHand().isEmpty()) {
                    finishRound();
                    return;
                }
                if (currentPlayer.getHand().size() == 1) {
                    System.out.println("say Uno!");
                }
                lastCard.play(this);
            } else {
                System.out.println("Draw a card. You don't have any cards match with the last played card.");
                getCardDrawer().drawCard(this);
            }
            separateLine();
            getPlayersHolder().movePlayer();
            if (getDrawPile().getPileSize() <= 5) {
                getDrawPile().merge(getDiscardPile());
            }
        }
    }

    @Override
    public void startGame() throws Exception {
        System.out.println("Welcome to The Uno game!");
        initGame();
        getPlayerGenerator().generate(this);
        for (int i = 1; i <= numberOfRounds; i++) {
            System.out.println("Round " + i + "/" + numberOfRounds);
            playRound();
            separateLine();
        }
        Player winner = getScoreCalculator().getTopPlayer(this);
        System.out.println("The winner is : " + winner.getName());
    }


    @Override
    public void initDrawPile() {
        setDrawPile(new DefaultPileManager());
    }

    @Override
    public void initCardDrawer() {
        setCardDrawer(new DefaultCardDrawer());
    }

    @Override
    public void initCardMatcher() {
        setCardMatcher(new DefaultCardMatcher());
    }

    @Override
    public void initDiscardPile() {
        setDiscardPile(new DefaultPileManager());
    }

    @Override
    public void initPlayersHolder() {
        setPlayersHolder(new DefaultPlayersHolder());
    }

    @Override
    public void initPileGenerator() {
        setPileGenerator(DefaultPileGenerator.getInstance());
    }

    @Override
    public void initCardDistributor() {
        setCardDistributor(new DefaultCardDistributor());
    }

    @Override
    public void initScoreCalculator() {
        setScoreCalculator(new DefaultScoreCalculator());
    }

    @Override
    public void initPlayerGenerator() {
        setPlayerGenerator(new DefaultPlayerGenerator());
    }
}
