import java.util.Random;
import java.util.Scanner;
public class AssCraps {
    private static final Random rnd = new Random();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain = true;
        while (playAgain) {
            playGame();
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = in.next().equalsIgnoreCase("yes");
        }
    }

    private static void playGame() {
        int roll = rollDice();
        System.out.println("You rolled: " + roll);

        if (roll == 2 || roll == 3 || roll == 12) {
            System.out.println("Craps! You lose.");
        } else if (roll == 7 || roll == 11) {
            System.out.println("Natural! You win.");
        } else {
            int point = roll;
            System.out.println("The point is now: " + point);
            boolean gameContinues = true;
            while (gameContinues) {
                roll = rollDice();
                System.out.println("You rolled: " + roll);
                if (roll == point) {
                    System.out.println("You made the point! You win.");
                    gameContinues = false;
                } else if (roll == 7) {
                    System.out.println("You rolled a 7! You lose.");
                    gameContinues = false;
                } else {
                    System.out.println("Trying for point...");
                }
            }
        }
    }

    private static int rollDice() {
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        System.out.println("Die 1: " + die1 + ", Die 2: " + die2);
        return die1 + die2;
    }

}