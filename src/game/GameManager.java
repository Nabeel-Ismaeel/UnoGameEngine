package game;

import service.CardDrawer;
import pile.PileGenerator;
import pile.PileManager;
import player.PlayerGenerator;
import player.PlayersHolder;
import service.CardDistributor;
import service.CardMatcher;
import service.ScoreCalculator;

public abstract class GameManager {
    private PileManager drawPile;
    private CardDrawer cardDrawer;
    private CardMatcher cardMatcher;
    private PileManager discardPile;
    private PlayersHolder playersHolder;
    private PileGenerator pileGenerator;
    private CardDistributor cardDistributor;
    private ScoreCalculator scoreCalculator;
    private PlayerGenerator playerGenerator;


    public abstract void startGame() throws Exception;

    public abstract void initDrawPile();

    public abstract void initCardDrawer();

    public abstract void initCardMatcher();

    public abstract void initDiscardPile();

    public abstract void initPlayersHolder();

    public abstract void initPileGenerator();

    public abstract void initCardDistributor();

    public abstract void initScoreCalculator();

    public abstract void initPlayerGenerator();

    public final void initGame() {
        initDrawPile();
        initCardDrawer();
        initCardMatcher();
        initDiscardPile();
        initPlayersHolder();
        initPileGenerator();
        initCardDistributor();
        initScoreCalculator();
        initPlayerGenerator();
    }


    public ScoreCalculator getScoreCalculator() {
        return scoreCalculator;
    }

    public void setScoreCalculator(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public PileGenerator getPileGenerator() {
        return pileGenerator;
    }

    public void setPileGenerator(PileGenerator pileGenerator) {
        this.pileGenerator = pileGenerator;
    }

    public PlayersHolder getPlayersHolder() {
        return playersHolder;
    }

    public void setPlayersHolder(PlayersHolder playersHolder) {
        this.playersHolder = playersHolder;
    }


    public PileManager getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(PileManager discardPile) {
        this.discardPile = discardPile;
    }

    public PileManager getDrawPile() {
        return drawPile;
    }

    public void setDrawPile(PileManager drawPile) {
        this.drawPile = drawPile;
    }

    public CardDistributor getCardDistributor() {
        return cardDistributor;
    }

    public void setCardDistributor(CardDistributor cardDistributor) {
        this.cardDistributor = cardDistributor;
    }

    public PlayerGenerator getPlayerGenerator() {
        return playerGenerator;
    }

    public void setPlayerGenerator(PlayerGenerator playerGenerator) {
        this.playerGenerator = playerGenerator;
    }

    public CardMatcher getCardMatcher() {
        return cardMatcher;
    }

    public void setCardMatcher(CardMatcher cardMatcher) {
        this.cardMatcher = cardMatcher;
    }

    public CardDrawer getCardDrawer() {
        return cardDrawer;
    }

    public void setCardDrawer(CardDrawer cardDrawer) {
        this.cardDrawer = cardDrawer;
    }
}
