import java.util.Arrays;
import java.util.Scanner;

public class PodiumFinder {

    // Method to find top 3 scores in a single pass without sorting
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }
        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of scores (min 3, max 10000): ");
        int n = scanner.nextInt();
        
        int[] scores = new int[n];
        System.out.println("Enter the scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        
        int[] topThree = findTopThreeScores(scores);
        System.out.println("Top 3 Scores: " + Arrays.toString(topThree));
        
        scanner.close();
    }
}
