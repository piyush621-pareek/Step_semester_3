
import java.util.*;

/**
 * Problem 1: Payment System Fee Calculation (no custom input — data hardcoded)
 *
 * Polymorphism: an abstract Payment base type defines finalAmount(); each
 * concrete payment applies its own fee. The main loop processes every payment
 * uniformly with no type checking.
 */
public class Problem1_PaymentSystem {

    abstract static class Payment {

        protected double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract String type();

        abstract double finalAmount();
    }

    static class CardPayment extends Payment {

        CardPayment(double a) {
            super(a);
        }

        String type() {
            return "CARD";
        }

        double finalAmount() {
            return amount * 1.02;
        }   // 2% fee
    }

    static class WalletPayment extends Payment {

        WalletPayment(double a) {
            super(a);
        }

        String type() {
            return "WALLET";
        }

        double finalAmount() {
            return amount * 1.01;
        }   // 1% fee
    }

    static class BankTransferPayment extends Payment {

        BankTransferPayment(double a) {
            super(a);
        }

        String type() {
            return "BANKTRANSFER";
        }

        double finalAmount() {
            return amount;
        }          // no fee
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<Payment> payments = Arrays.asList(
                new CardPayment(1000),
                new WalletPayment(500),
                new BankTransferPayment(2000)
        );

        double total = 0;
        for (Payment p : payments) {          // uniform processing
            double amt = p.finalAmount();
            total += amt;
            System.out.printf("%s: %.2f%n", p.type(), amt);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
