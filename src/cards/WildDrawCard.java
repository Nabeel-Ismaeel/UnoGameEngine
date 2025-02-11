package cards;

import cards.commands.Command;

public class WildDrawCard extends Card {

    public WildDrawCard(Integer points, Color color, Type type, Command command) {
        super(points, color, type);
        setCommand(command);
    }
}
