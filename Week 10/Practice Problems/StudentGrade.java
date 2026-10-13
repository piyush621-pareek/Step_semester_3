import java.util.Scanner;
public class StudentGrade {
    static char grade(int m) {
        if (m >= 90) return 'A';
        else if (m >= 75) return 'B';
        else if (m >= 60) return 'C';
        else if (m >= 40) return 'D';
        else return 'F';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            System.out.println("Grade " + grade(m));
        }
    }
}