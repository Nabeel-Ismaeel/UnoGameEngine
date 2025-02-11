package cards;

import cards.commands.Command;

public class SkipCard extends Card {

    public SkipCard(Integer points, Color color, Type type, Command command) {
        super(points, color, type);
        setCommand(command);
    }
}
