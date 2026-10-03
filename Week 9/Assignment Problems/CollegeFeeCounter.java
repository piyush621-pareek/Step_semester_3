import java.util.Scanner;

// Transport fee is written ONCE. "Uses the bus" is a capability -> marker interface.
abstract class Student {
    protected final String name;
    protected Student(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract double tuition();
}
interface BusUser { }                 // marker: this student uses the college bus

class DayScholar extends Student implements BusUser {
    DayScholar(String n) { super(n); }
    public double tuition() { return 40000; }
}
class Hosteller extends Student {     // no bus
    Hosteller(String n) { super(n); }
    public double tuition() { return 40000 + 60000; }   // tuition + hostel
}
class ScholarStudent extends Student implements BusUser {
    ScholarStudent(String n) { super(n); }
    public double tuition() { return 20000; }            // half tuition
}

public class CollegeFeeCounter {
    static final double TRANSPORT_FEE = 12000;           // one place only
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            Student s;
            switch (t[0]) {
                case "DAY_SCHOLAR": s = new DayScholar(t[1]); break;
                case "HOSTELLER":   s = new Hosteller(t[1]); break;
                default:            s = new ScholarStudent(t[1]);
            }
            double fee = s.tuition() + (s instanceof BusUser ? TRANSPORT_FEE : 0);
            total += fee;
            System.out.printf("%s: %.2f%n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}