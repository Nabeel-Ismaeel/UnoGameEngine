package service;

import cards.Color;
import game.GameManager;

import java.util.Scanner;

public class DefaultColorChanger implements ColorChanger {
    @Override
    public void changeColor(GameManager gameManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the color:\n1-Red\n2-Green\n3-Blue\n4-Yellow");
        Color color = ColorFactory.getColor(scanner.nextLine().toLowerCase());
        while (color == Color.Wield) {
            System.out.println("Please enter a valid name for the color:\n1-Red\n2-Green\n3-Blue\n4-Yellow");
            color = ColorFactory.getColor(scanner.nextLine().toLowerCase());
        }
        gameManager.getDiscardPile().getLastCard().setColor(color);
    }
}
