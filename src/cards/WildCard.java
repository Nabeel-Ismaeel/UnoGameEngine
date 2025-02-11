package cards;

import cards.commands.Command;

public class WildCard extends Card {

    public WildCard(Integer points, Color color, Type type, Command command) {
        super(points, color, type);
        setCommand(command);
    }
}
