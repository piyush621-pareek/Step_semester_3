
import java.util.*;

/**
 * Problem 1: The Canteen Billing Counter (no custom input — data hardcoded)
 *
 * Polymorphism: an abstract Customer base type defines finalAmount(); each
 * customer type applies its own pricing rule. The counter processes all bills
 * uniformly with no type checking.
 */
public class A_Problem1_CanteenBilling {

    abstract static class Customer {

        protected double bill;

        Customer(double bill) {
            this.bill = bill;
        }

        abstract String type();

        abstract double finalAmount();
    }

    static class Student extends Customer {

        Student(double b) {
            super(b);
        }

        String type() {
            return "STUDENT";
        }

        double finalAmount() {
            return bill * 0.90;
        }      // 10% discount
    }

    static class Staff extends Customer {

        Staff(double b) {
            super(b);
        }

        String type() {
            return "STAFF";
        }

        double finalAmount() {
            return bill * 0.95;
        }      // 5% discount
    }

    static class Guest extends Customer {

        Guest(double b) {
            super(b);
        }

        String type() {
            return "GUEST";
        }

        double finalAmount() {
            return bill + 10;
        }        // +₹10 service charge
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<Customer> bills = Arrays.asList(
                new Student(200),
                new Staff(300),
                new Guest(150)
        );

        double total = 0;
        for (Customer c : bills) {            // uniform processing
            double amt = c.finalAmount();
            total += amt;
            System.out.printf("%s: %.2f%n", c.type(), amt);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
