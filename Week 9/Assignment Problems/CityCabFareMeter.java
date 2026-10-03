import java.util.Scanner;

// Minimum-fare rule is shared (base class). Night service is an ability -> interface.
abstract class Cab {
    protected static final double MIN_FARE = 100.0;
    protected abstract double ratePerKm();
    protected abstract String type();
    public double fare(double km) { return Math.max(km * ratePerKm(), MIN_FARE); }
}
interface NightService { }            // only cabs that offer night trips implement this

class MiniCab extends Cab {
    protected double ratePerKm() { return 10; }
    protected String type() { return "MINI"; }
}
class SedanCab extends Cab implements NightService {
    protected double ratePerKm() { return 14; }
    protected String type() { return "SEDAN"; }
}
class SuvCab extends Cab implements NightService {
    protected double ratePerKm() { return 18; }
    protected String type() { return "SUV"; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double km = Double.parseDouble(t[1]);
            boolean night = t[2].equals("NIGHT");
            Cab c;
            switch (t[0]) {
                case "MINI":  c = new MiniCab(); break;
                case "SEDAN": c = new SedanCab(); break;
                default:      c = new SuvCab();
            }
            if (night && !(c instanceof NightService)) {
                System.out.printf("%s: night service not available%n", c.type());
                continue;                       // rejected trip not counted
            }
            double fare = c.fare(km);
            if (night) fare *= 1.20;            // 20% after the minimum
            total += fare;
            System.out.printf("%s: %.2f%n", c.type(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}