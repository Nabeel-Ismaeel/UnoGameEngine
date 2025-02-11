package cards;

import cards.commands.Command;

public class DrawTwoCard extends Card {

    public DrawTwoCard(Integer points, Color color, Type type, Command command) {
        super(points, color, type);
        setCommand(command);
    }
}
