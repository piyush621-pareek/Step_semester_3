import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of people on the team: ");
        int n = scanner.nextInt();
        
        double[] heights = new double[n];
        double[] weights = new double[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter height (in meters) for Person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            System.out.print("Enter weight (in kg) for Person " + (i + 1) + ": ");
            weights[i] = scanner.nextDouble();
        }
        
        System.out.println("\n--- Wellness Report ---");
        printWellnessReport(heights, weights);
        
        scanner.close();
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-6d | %-10.2f | %-11.2f | %-5.2f | %s\n", 
                              (i + 1), heights[i], weights[i], bmi, status);
        }
    }
}