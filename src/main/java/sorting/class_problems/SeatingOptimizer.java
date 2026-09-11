import java.util.Scanner;

public class SeatingOptimizer {

    // Private helper to compute the average of a single row
    private static double rowAverage(int[] row) {
        if (row.length == 0) return 0.0;
        double sum = 0;
        for (int score : row) {
            sum += score;
        }
        return sum / row.length;
    }

    // Method to classify each row based on the threshold
    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";
            
            result.append("Row ").append(i).append(": ").append(zone);
            if (i < seatingScores.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of seating rows: ");
        int rows = scanner.nextInt();
        
        int[][] seatingScores = new int[rows][];
        
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter the number of teams in Row " + i + ": ");
            int cols = scanner.nextInt();
            seatingScores[i] = new int[cols];
            
            System.out.print("Enter scores for Row " + i + ": ");
            for (int j = 0; j < cols; j++) {
                seatingScores[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print("Enter the average score threshold: ");
        int threshold = scanner.nextInt();
        
        System.out.println(classifyRows(seatingScores, threshold));
        
        scanner.close();
    }
}