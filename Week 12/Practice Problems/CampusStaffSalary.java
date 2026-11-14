import java.util.Scanner;
// Time: O(n) to print all salaries.
public class CampusStaffSalary {
    static class Staff {
        String name; double baseSalary;
        Staff(String n, double b) { name = n; baseSalary = b; }
        double getBonus() { return 0; }
        String type() { return getClass().getSimpleName(); }
        double total() { return baseSalary + getBonus(); }
        void print() {
            System.out.println(name + " (" + type() + "): base " + baseSalary + ", bonus " + getBonus() + ", total " + total());
        }
    }
    static class Teacher extends Staff {
        Teacher(String n, double b) { super(n, b); }
        @Override double getBonus() { return 5000; }
    }
    static class LabAssistant extends Staff {
        LabAssistant(String n, double b) { super(n, b); }
        @Override double getBonus() { return 2000; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        for (int i = 0; i < n; i++) {
            String t = sc.next(), name = sc.next(); double b = sc.nextDouble();
            if (t.equals("Teacher")) staff[i] = new Teacher(name, b);
            else if (t.equals("LabAssistant")) staff[i] = new LabAssistant(name, b);
            else staff[i] = new Staff(name, b);
        }
        double grand = 0;
        for (Staff s : staff) { s.print(); grand += s.total(); }
        System.out.println("Grand Total Salary: " + grand);
    }
}