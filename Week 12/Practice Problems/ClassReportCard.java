import java.util.Scanner;
// Bubble sort with early stop: best O(n), worst O(n^2).
public class ClassReportCard {
    static class Student {
        private String name; private int a, b, c;
        Student(String name) { this.name = name; }
        boolean setMarks(int a, int b, int c) {
            if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) return false;
            this.a = a; this.b = b; this.c = c; return true;
        }
        String getName() { return name; }
        int total() { return a + b + c; }
        double avg() { return total() / 3.0; }
        char grade() {
            double v = avg();
            if (v >= 80) return 'A'; if (v >= 70) return 'B'; if (v >= 60) return 'C'; if (v >= 40) return 'D'; return 'F';
        }
        @Override public String toString() {
            return name + " total=" + total() + " avg=" + String.format("%.2f", avg()) + " grade=" + grade();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] list = new Student[n]; int k = 0;
        for (int i = 0; i < n; i++) {
            Student s = new Student(sc.next());
            if (s.setMarks(sc.nextInt(), sc.nextInt(), sc.nextInt())) list[k++] = s;
            else System.out.println(s.getName() + " skipped: marks must be 0 to 100");
        }
        int passes = 0;
        for (int i = 0; i < k - 1; i++) {
            passes++;
            boolean swapped = false;
            for (int j = 0; j < k - 1 - i; j++)
                if (list[j].total() < list[j + 1].total()) {
                    Student t = list[j]; list[j] = list[j + 1]; list[j + 1] = t; swapped = true;
                }
            if (!swapped) break;
        }
        for (int i = 0; i < k; i++) System.out.println((i + 1) + ". " + list[i]);
        System.out.println("Sorted in " + passes + " passes");
    }
}