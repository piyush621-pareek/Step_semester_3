import java.util.Scanner;

// abstract Staff cannot be instantiated -> no "generic staff member" is ever created.
abstract class Staff {
    private final String name;
    protected Staff(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract double pay();
}

class FullTimeStaff extends Staff {
    private final double weeklySalary;
    public FullTimeStaff(String name, double s) { super(name); weeklySalary = s; }
    public double pay() { return weeklySalary; }
}

class HourlyStaff extends Staff {
    private final double hours, rate;
    public HourlyStaff(String name, double h, double r) { super(name); hours = h; rate = r; }
    public double pay() {
        if (hours <= 40) return hours * rate;
        return 40 * rate + (hours - 40) * rate * 1.5;   // overtime at 1.5x
    }
}

class InternStaff extends Staff {
    private final double stipend;
    public InternStaff(String name, double s) { super(name); stipend = s; }
    public double pay() { return stipend; }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            Staff s;
            switch (t[0]) {
                case "FULLTIME": s = new FullTimeStaff(t[1], Double.parseDouble(t[2])); break;
                case "HOURLY":   s = new HourlyStaff(t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3])); break;
                default:         s = new InternStaff(t[1], Double.parseDouble(t[2]));
            }
            total += s.pay();
            System.out.printf("%s: %.2f%n", s.getName(), s.pay());
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}