import java.util.Random;
import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        String playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            int number = random.nextInt(100) + 1;

            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct!");
                    System.out.println("You guessed it in "
                            + attempts + " attempts.");

                    score += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                    break;

                } else if (guess < number) {
                    System.out.println("Too low!");

                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\nGame over!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Your current score: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Final Score: " + score);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}