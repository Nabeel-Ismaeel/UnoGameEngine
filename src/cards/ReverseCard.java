package cards;

import cards.commands.Command;

public class ReverseCard extends Card {

    public ReverseCard(Integer points, Color color, Type type, Command command) {
        super(points, color, type);
        setCommand(command);
    }
}
