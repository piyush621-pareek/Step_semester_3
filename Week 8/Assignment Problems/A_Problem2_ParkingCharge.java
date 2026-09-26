
import java.util.*;

/**
 * Problem 2: The Campus Parking Charge Calculator (no custom input — hardcoded)
 *
 * Polymorphism: each Vehicle type computes its own parking charge from the
 * hours parked. The system processes all vehicles uniformly.
 */
public class A_Problem2_ParkingCharge {

    abstract static class Vehicle {

        protected int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract String type();

        abstract double charge();
    }

    static class Bike extends Vehicle {

        Bike(int h) {
            super(h);
        }

        String type() {
            return "BIKE";
        }

        double charge() {
            return 10.0 * hours;
        }               // ₹10 per hour
    }

    static class Car extends Vehicle {

        Car(int h) {
            super(h);
        }

        String type() {
            return "CAR";
        }

        double charge() {
            return 30 + 20.0 * (hours - 1);
        }    // ₹30 first hr, ₹20 each extra
    }

    static class Truck extends Vehicle {

        Truck(int h) {
            super(h);
        }

        String type() {
            return "TRUCK";
        }

        double charge() {
            return Math.max(50.0 * hours, 100);
        } // ₹50/hr, min ₹100
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<Vehicle> vehicles = Arrays.asList(
                new Bike(3),
                new Car(4),
                new Truck(1),
                new Car(1)
        );

        double total = 0;
        for (Vehicle v : vehicles) {          // uniform processing
            double c = v.charge();
            total += c;
            System.out.printf("%s: %.2f%n", v.type(), c);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
