import java.util.Arrays;
import java.util.Scanner;

public class ScoreBooster {
    
    // Method to boost scores in place
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of teams (up to 200): ");
        int n = scanner.nextInt();
        
        int[] scores = new int[n];
        System.out.println("Enter the scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the bonus to add: ");
        int bonus = scanner.nextInt();
        
        curveScores(scores, bonus);
        
        // Print using standard library formatter
        System.out.println("Boosted Leaderboard: " + Arrays.toString(scores));
        
        scanner.close();
    }
}