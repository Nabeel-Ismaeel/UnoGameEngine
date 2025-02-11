package player;

import game.GameManager;

import java.util.Scanner;

public class DefaultPlayerGenerator implements PlayerGenerator {
    private int playerNumber;

    public DefaultPlayerGenerator() {
        this.playerNumber = 0;
    }

    @Override
    public void generate(GameManager gameManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of the player: ");
        playerNumber = scanner.nextInt();
        while (playerNumber < 2 || playerNumber > 10) {
            System.out.println("Please enter a valid number of the player (2 - 10): ");
            playerNumber = scanner.nextInt();
        }

        for (int i = 1; i <= playerNumber; i++) {
            System.out.println("enter the name of player number " + i + " : ");
            String name = scanner.next();
            System.out.println("enter the age of player number " + i + " : ");
            int age = scanner.nextInt();
            Player player = new Player(name, age);
            gameManager.getPlayersHolder().addPlayer(player);
        }
    }
}
