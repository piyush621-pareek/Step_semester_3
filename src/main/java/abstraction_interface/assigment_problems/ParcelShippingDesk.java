import java.util.Scanner;

// "how much to ship?" -> every parcel answers (abstract charge()).
// "can it be insured?" -> only some can -> a separate INTERFACE.
abstract class Parcel {
    protected final double weightKg, declaredValue;
    protected Parcel(double w, double v) { weightKg = w; declaredValue = v; }
    public abstract double charge();
    public abstract String type();
}
interface Insurable {
    double insurance();              // only insurable parcels implement this
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) { super(w, v); }
    public double charge() { return 40 + 10 * weightKg; }
    public String type() { return "STANDARD"; }
}
class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { super(w, v); }
    public double charge() { return 80 + 15 * weightKg; }
    public double insurance() { return 0.02 * declaredValue; }
    public String type() { return "EXPRESS"; }
}
class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double w, double v) { super(w, v); }
    public double charge() { return (40 + 10 * weightKg) + 50; }   // standard + handling
    public double insurance() { return 0.02 * declaredValue; }
    public String type() { return "FRAGILE"; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double w = Double.parseDouble(t[1]), v = Double.parseDouble(t[2]);
            Parcel p;
            switch (t[0]) {
                case "STANDARD": p = new StandardParcel(w, v); break;
                case "EXPRESS":  p = new ExpressParcel(w, v); break;
                default:         p = new FragileParcel(w, v);
            }
            double ins = (p instanceof Insurable) ? ((Insurable) p).insurance() : 0.0;
            double tot = p.charge() + ins;
            grand += tot;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.type(), p.charge(), ins, tot);
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }
}