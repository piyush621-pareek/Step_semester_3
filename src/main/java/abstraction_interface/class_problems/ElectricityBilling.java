import java.util.Scanner;

abstract class Connection {
    protected final int units;
    protected Connection(int units) { this.units = units; }
    public abstract double bill();
    public abstract String type();
}

class HomeConnection extends Connection {
    public HomeConnection(int u) { super(u); }
    public double bill() {
        if (units <= 100) return 5.0 * units;
        return 5.0 * 100 + 7.0 * (units - 100);     // slab tariff
    }
    public String type() { return "HOME"; }
}

class ShopConnection extends Connection {
    public ShopConnection(int u) { super(u); }
    public double bill() { return 8.0 * units + 100; }   // per unit + fixed charge
    public String type() { return "SHOP"; }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int u) { super(u); }
    public double bill() { return Math.max(6.0 * units, 1000.0); }   // minimum bill
    public String type() { return "FACTORY"; }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            int u = Integer.parseInt(t[1]);
            Connection c;
            switch (t[0]) {
                case "HOME":    c = new HomeConnection(u); break;
                case "SHOP":    c = new ShopConnection(u); break;
                default:        c = new FactoryConnection(u);
            }
            total += c.bill();
            System.out.printf("%s: %.2f%n", c.type(), c.bill());
        }
        System.out.printf("Total: %.2f%n", total);
    }
}