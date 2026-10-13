import java.util.Scanner;
public class StudentResultCard {
    static class Student {
        String name; int[] marks;
        Student(String name, int[] marks) { this.name = name; this.marks = marks; }
        double average() {
            int sum = 0;
            for (int m : marks) sum += m;
            return (double) sum / marks.length;
        }
        char grade() {
            double a = average();
            if (a >= 90) return 'A';
            else if (a >= 75) return 'B';
            else if (a >= 60) return 'C';
            else if (a >= 40) return 'D';
            else return 'F';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String name = line.split("[\\s\\[]")[0];
            String[] tok = line.split("[^-0-9]+");
            java.util.List<Integer> nums = new java.util.ArrayList<>();
            for (String t : tok) if (!t.isEmpty()) nums.add(Integer.parseInt(t));
            int[] marks = new int[nums.size()];
            for (int i = 0; i < marks.length; i++) marks[i] = nums.get(i);
            Student s = new Student(name, marks);
            System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), s.average(), s.grade());
        }
    }
}