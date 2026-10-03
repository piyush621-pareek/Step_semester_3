import java.util.Scanner;

// Units are computed the same way for all. Saver mode is optional -> interface.
abstract class Appliance {
    protected final double hours;
    protected Appliance(double hours) { this.hours = hours; }
    protected abstract double powerW();
    protected abstract String name();
    public double units() { return powerW() * hours / 1000.0; }   // kWh
}
interface SaverMode { }                // only appliances with a saver mode implement this

class Fridge extends Appliance {
    Fridge(double h) { super(h); }
    protected double powerW() { return 150; }
    protected String name() { return "FRIDGE"; }
}
class AC extends Appliance implements SaverMode {
    AC(double h) { super(h); }
    protected double powerW() { return 1500; }
    protected String name() { return "AC"; }
}
class TV extends Appliance {
    TV(double h) { super(h); }
    protected double powerW() { return 100; }
    protected String name() { return "TV"; }
}
class Washer extends Appliance implements SaverMode {
    Washer(double h) { super(h); }
    protected double powerW() { return 500; }
    protected String name() { return "WASHER"; }
}

public class ApplianceEnergyReport {
    static final double RATE = 8.0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double h = Double.parseDouble(t[1]);
            boolean saver = t.length > 2 && t[2].equals("SAVER");
            Appliance a;
            switch (t[0]) {
                case "FRIDGE": a = new Fridge(h); break;
                case "AC":     a = new AC(h); break;
                case "TV":     a = new TV(h); break;
                default:       a = new Washer(h);
            }
            if (saver && !(a instanceof SaverMode)) {
                System.out.printf("%s: saver mode not supported%n", a.name());
                continue;
            }
            double units = a.units();
            if (saver) units *= 0.75;          // saver reduces by 25%
            double cost = units * RATE;
            total += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.name(), units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }
}