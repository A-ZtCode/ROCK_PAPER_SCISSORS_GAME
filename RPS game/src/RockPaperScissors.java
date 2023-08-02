import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxRounds = 10;
        int minRounds = 1;
        String playAgain;

        do {
            System.out.print("How many rounds do you want to play? (1-10): ");
            int numRounds = scanner.nextInt();

            // Validate the number of rounds
            if (numRounds < minRounds || numRounds > maxRounds) {
                System.out.println("Invalid number of rounds. Exiting the game.");
                break;
            }

            int ties = 0;
            int userWins = 0;
            int computerWins = 0;

            // Play each round of Rock, Paper, Scissors
            for (int round = 1; round <= numRounds; round++) {
                System.out.println("\nRound " + round + ":");
                System.out.print("Enter your choice (1 = Rock, 2 = Paper, 3 = Scissors): ");
                int userChoice = scanner.nextInt();

                // Validate the user's choice
                if (userChoice < 1 || userChoice > 3) {
                    System.out.println("Invalid choice. Skipping this round.");
                    continue;
                }

                // Generate the computer's choice randomly
                int computerChoice = random.nextInt(3) + 1;
                String computerChoiceName = "";
                if (computerChoice == 1) {
                    computerChoiceName = "Rock";
                } else if (computerChoice == 2) {
                    computerChoiceName = "Paper";
                } else if (computerChoice == 3) {
                    computerChoiceName = "Scissors";
                }
                System.out.println("Computer's choice: " + computerChoiceName);

                // Determine the winner for the current round
                int result = 0;
                if (userChoice == computerChoice) {
                    System.out.println("It's a tie!");
                    ties++;
                } else if ((userChoice == 1 && computerChoice == 3) ||
                        (userChoice == 2 && computerChoice == 1) ||
                        (userChoice == 3 && computerChoice == 2)) {
                    System.out.println("You win!");
                    userWins++;
                } else {
                    System.out.println("Computer wins!");
                    computerWins++;
                }
            }

            System.out.println("\n--- Game Over ---");
            System.out.println("Number of ties: " + ties);
            System.out.println("Number of user wins: " + userWins);
            System.out.println("Number of computer wins: " + computerWins);

            // Determine the overall winner
            if (userWins > computerWins) {
                System.out.println("You are the overall winner!");
            } else if (computerWins > userWins) {
                System.out.println("Computer is the overall winner!");
            } else {
                System.out.println("It's a tie overall!");
            }

            System.out.print("\nDo you want to play again? (Yes/No): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("Yes"));

        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
