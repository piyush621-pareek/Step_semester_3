import java.util.Scanner;
public class LeapYearDetector {
    static boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int y = sc.nextInt();
            System.out.println(isLeap(y) ? "Leap year" : "Not a leap year");
        }
    }
}