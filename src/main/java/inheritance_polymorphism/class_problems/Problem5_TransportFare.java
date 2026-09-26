
import java.util.*;

/**
 * Problem 5: Public Transport Fare Calculator (no custom input — data
 * hardcoded)
 *
 * Polymorphism: each transport type computes its own fare from distance (Metro
 * also uses a peak-hour factor; Bus is capped at $10). The main loop processes
 * every journey uniformly.
 */
public class Problem5_TransportFare {

    abstract static class Transport {

        protected double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract String type();

        abstract double fare();
    }

    static class Bus extends Transport {

        Bus(double d) {
            super(d);
        }

        String type() {
            return "BUS";
        }

        double fare() {
            return Math.min(2 + 0.10 * distance, 10);
        } // max $10
    }

    static class Train extends Transport {

        Train(double d) {
            super(d);
        }

        String type() {
            return "TRAIN";
        }

        double fare() {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {

        private double peakFactor;

        Metro(double d, double peakFactor) {
            super(d);
            this.peakFactor = peakFactor;
        }

        String type() {
            return "METRO";
        }

        double fare() {
            return (1.50 + 0.20 * distance) * peakFactor;
        }
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<Transport> journeys = Arrays.asList(
                new Bus(15),
                new Train(50),
                new Metro(10, 1.5)
        );

        double total = 0;
        for (Transport t : journeys) {        // uniform processing
            double f = t.fare();
            total += f;
            System.out.printf("%s: %.2f%n", t.type(), f);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
