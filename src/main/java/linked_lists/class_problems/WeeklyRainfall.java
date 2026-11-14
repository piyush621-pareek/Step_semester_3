import java.util.Scanner;
// Time O(n), Space O(n) for the 7 readings.
public class WeeklyRainfall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] r = new double[7];
        for (int i = 0; i < 7; i++) r[i] = sc.nextDouble();
        StringBuilder sb = new StringBuilder("Rainfall (mm):");
        double total = 0; int wet = 0, dry = 0;
        for (int i = 0; i < 7; i++) {
            sb.append(" ").append(r[i]);
            total += r[i];
            if (r[i] > r[wet]) wet = i;
            if (r[i] == 0) dry++;
        }
        System.out.println(sb);
        System.out.println("Total Rainfall: " + total + " mm");
        System.out.printf("Average Rainfall: %.2f mm%n", total / 7);
        System.out.println("Wettest Day: Day " + (wet + 1) + " (" + r[wet] + " mm)");
        System.out.println("Total Dry Days: " + dry);
    }
}