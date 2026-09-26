
import java.util.*;

/**
 * Problem 3: The Hostel Electricity Bill (no custom input — data hardcoded)
 *
 * Polymorphism: each Room type computes its own bill. A shared room stores the
 * extra "occupants" value itself, so the main loop still treats every room the
 * same way.
 */
public class A_Problem3_HostelElectricity {

    abstract static class Room {

        protected int units;

        Room(int units) {
            this.units = units;
        }

        abstract String type();

        abstract double bill();
    }

    static class SingleRoom extends Room {

        SingleRoom(int u) {
            super(u);
        }

        String type() {
            return "SINGLE";
        }

        double bill() {
            return 8.0 * units;
        }               // ₹8 per unit
    }

    static class SharedRoom extends Room {

        private int occupants;

        SharedRoom(int u, int occupants) {
            super(u);
            this.occupants = occupants;
        }

        String type() {
            return "SHARED";
        }

        double bill() {
            return (6.0 * units) / occupants;
        } // ₹6/unit split equally
    }

    static class AcRoom extends Room {

        AcRoom(int u) {
            super(u);
        }

        String type() {
            return "AC";
        }

        double bill() {
            return 10.0 * units + 200;
        }        // ₹10/unit + ₹200 fixed
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<Room> rooms = Arrays.asList(
                new SingleRoom(120),
                new SharedRoom(150, 3),
                new AcRoom(100)
        );

        double total = 0;
        for (Room r : rooms) {                // uniform processing
            double b = r.bill();
            total += b;
            System.out.printf("%s: %.2f%n", r.type(), b);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
