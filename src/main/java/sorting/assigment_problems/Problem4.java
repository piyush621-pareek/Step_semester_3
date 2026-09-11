import java.util.Scanner;

public class Problem4 {
    private static double rowAverage(int[] row) {
        double sum = 0;
        for (int runs : row) sum += runs;
        return row.length > 0 ? sum / row.length : 0;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            String type = rowAverage(runsPerOver[i]) >= threshold ? "Power Surge" : "Normal";
            sb.append("Match ").append(i).append(": ").append(type);
            if (i < runsPerOver.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of matches and threshold: ");
        int m = sc.nextInt(), t = sc.nextInt();
        int[][] matches = new int[m][];
        
        for (int i = 0; i < m; i++) {
            System.out.print("Enter number of overs for Match " + i + ", then runs per over: ");
            matches[i] = new int[sc.nextInt()];
            for (int j = 0; j < matches[i].length; j++) matches[i][j] = sc.nextInt();
        }
        System.out.println(classifyMatches(matches, t));
    }
}