package Task2;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            playGame(scanner, random);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();

            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thanks for playing! Goodbye!");
        scanner.close();
    }

    private static void playGame(Scanner scanner, Random random) {
        int lowerBound = 1;
        int upperBound = 100;
        int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Enter your guess (Attempt " + attempt + "/" + maxAttempts + "): ");
            int userGuess = scanner.nextInt();

            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                score += (maxAttempts - attempt + 1) * 10;
                break;
            } else if (userGuess < generatedNumber) {
                System.out.println("Too low. Try again!");
            } else {
                System.out.println("Too high. Try again!");
            }

            if (attempt == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
            }
        }

        System.out.println("Your final score: " + score);
        System.out.println();
    }
}

