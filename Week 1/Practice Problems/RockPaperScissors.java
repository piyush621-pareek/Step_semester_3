import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        System.out.print("Enter number of rounds to play (e.g., 5): ");
        int rounds = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            String pMove = scanner.nextLine();
            String cMove = options[random.nextInt(3)];
            
            String result = playRound(pMove, cMove);
            
            playerMoves[i] = pMove;
            computerMoves[i] = cMove;
            results[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            
            System.out.println("Player: " + pMove + ", Computer: " + cMove + " | " + result + "\n");
        }

        System.out.println("--- Final Summary (after " + rounds + " rounds) ---");
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + " | " + playerMoves[i] + " | " + computerMoves[i] + " | " + results[i]);
        }
        
        double winPercentage = ((double) wins / rounds) * 100;
        System.out.printf("\nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
        
        scanner.close();
    }

    public static String playRound(String playerMove, String computerMove) {
        playerMove = playerMove.trim().toLowerCase();
        computerMove = computerMove.toLowerCase();

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }
}