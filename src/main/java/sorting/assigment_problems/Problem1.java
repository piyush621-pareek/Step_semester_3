import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players, then the scores: ");
        int n = sc.nextInt();
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextDouble();
        
        System.out.print("Enter captain index and vice-captain index: ");
        applyMultipliers(scores, sc.nextInt(), sc.nextInt());
        System.out.println(Arrays.toString(scores));
    }
}