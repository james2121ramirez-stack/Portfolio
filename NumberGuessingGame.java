import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        String playAgain = "yes";

        System.out.println("================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("================================");
        System.out.println("Welcome, Player!");

        while (playAgain.equalsIgnoreCase("yes")) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess a number from 1 to 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");

                if (!input.hasNextInt()) {
                    input.next();
                    System.out.println("Please enter a whole number from 1 to 100.");
                    continue;
                }

                int guess = input.nextInt();
                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number from 1 to 100.");
                    continue;
                }

                attempts++;

                if (guess == secretNumber) {
                    System.out.println("\nCongratulations! You guessed it!");
                    System.out.println("Attempts used: " + attempts);
                    score += (maxAttempts - attempts + 1) * 10;
                    System.out.println("Your score: " + score);
                    guessedCorrectly = true;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = input.next();
        }

        System.out.println("\n================================");
        System.out.println("          GAME SUMMARY");
        System.out.println("================================");
        System.out.println("Final Score: " + score);
        System.out.println("Thank you for playing!");
        System.out.println("================================");

        input.close();
    }
}
