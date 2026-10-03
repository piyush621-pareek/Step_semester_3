import java.util.Scanner;

// The booking fee lives in ONE place (the base class). Change it here only.
abstract class Booking {
    protected static final double BOOKING_FEE = 50.0;
    protected final double distanceKm;
    protected Booking(double distanceKm) { this.distanceKm = distanceKm; }
    protected abstract double fare();           // mode-specific base fare
    protected abstract String mode();
    public double total() { return fare() + BOOKING_FEE; }   // shared fee added once
}

class BusBooking extends Booking {
    public BusBooking(double d) { super(d); }
    protected double fare() { return 2.0 * distanceKm; }
    protected String mode() { return "BUS"; }
}

class TrainBooking extends Booking {
    public TrainBooking(double d) { super(d); }
    protected double fare() { return 1.5 * distanceKm; }
    protected String mode() { return "TRAIN"; }
}

class FlightBooking extends Booking {
    public FlightBooking(double d) { super(d); }
    protected double fare() { return 2500 + 4.0 * distanceKm; }
    protected String mode() { return "FLIGHT"; }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double d = Double.parseDouble(t[1]);
            Booking b;
            switch (t[0]) {
                case "BUS":    b = new BusBooking(d); break;
                case "TRAIN":  b = new TrainBooking(d); break;
                default:       b = new FlightBooking(d);
            }
            System.out.printf("%s: %.2f%n", b.mode(), b.total());
        }
    }
}