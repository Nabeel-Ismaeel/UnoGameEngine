package cards;

import cards.commands.Command;
import cards.commands.NoOpCommand;
import game.GameManager;

import java.util.Objects;

public abstract class Card {
    private Type type;
    private Color color;
    private Integer points;
    private Command command = new NoOpCommand();

    public Card(Integer points, Color color, Type type) {
        this.points = points;
        this.color = color;
        this.type = type;
    }

    public void play(GameManager gameManager) throws Exception {
        command.execute(gameManager);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return type == card.type && color == card.color && Objects.equals(points, card.points) && Objects.equals(command, card.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, points, command);
    }

    @Override
    public String toString() {
        return "Card{" +
                "type=" + type +
                ", color=" + color +
                '}';
    }
}
