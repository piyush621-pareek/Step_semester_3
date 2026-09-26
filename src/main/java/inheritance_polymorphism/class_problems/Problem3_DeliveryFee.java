
import java.util.*;

/**
 * Problem 3: Delivery Fee Calculator (no custom input — data hardcoded)
 *
 * Polymorphism: each Delivery type computes its own fee from weight/distance.
 * International also adds a customs fee. Main loop processes all uniformly.
 *
 * NOTE: fees follow the stated business rules. (The PDF's sample expected
 * output for EXPRESS/INTERNATIONAL is inconsistent with those rules.)
 */
public class Problem3_DeliveryFee {

    abstract static class Delivery {

        protected double weight, distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract String type();

        abstract double fee();
    }

    static class StandardDelivery extends Delivery {

        StandardDelivery(double w, double d) {
            super(w, d);
        }

        String type() {
            return "STANDARD";
        }

        double fee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class ExpressDelivery extends Delivery {

        ExpressDelivery(double w, double d) {
            super(w, d);
        }

        String type() {
            return "EXPRESS";
        }

        double fee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class InternationalDelivery extends Delivery {

        private double customsFee;

        InternationalDelivery(double w, double d, double customsFee) {
            super(w, d);
            this.customsFee = customsFee;
        }

        String type() {
            return "INTERNATIONAL";
        }

        double fee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<Delivery> deliveries = Arrays.asList(
                new StandardDelivery(10, 50),
                new ExpressDelivery(5, 20),
                new InternationalDelivery(20, 100, 30)
        );

        double total = 0;
        for (Delivery del : deliveries) {     // uniform processing
            double f = del.fee();
            total += f;
            System.out.printf("%s: %.2f%n", del.type(), f);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
