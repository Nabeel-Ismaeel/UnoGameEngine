package service;

import cards.Color;

public class ColorFactory {
    public static Color getColor(String color) {
        switch (color) {
            case "red":
                return Color.Red;
            case "blue":
                return Color.Blue;
            case "green":
                return Color.Green;
            case "yellow":
                return Color.Yellow;
            default:
                return Color.Wield;
        }
    }
}
