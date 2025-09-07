import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int min = 1, max = 100;
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        Scanner scanner = new Scanner(System.in);
        int guess;
        int attempts = 0;
        int maxAttempts = 10; // limit attempts

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + min + " and " + max + ".");
        System.out.println("You have " + maxAttempts + " attempts. Good luck!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next();
                continue;
            }

            guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else {
                // Give hint
                int diff = Math.abs(randomNumber - guess);
                if (guess < randomNumber) {
                    System.out.print("Too low! ");
                } else {
                    System.out.print("Too high! ");
                }

                if (diff <= 5) {
                    System.out.println("You are very close!");
                } else if (diff <= 10) {
                    System.out.println("Getting warmer.");
                } else {
                    System.out.println("Far off, try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("😢 Game Over! The number was: " + randomNumber);
        }

        scanner.close();
    }
}
