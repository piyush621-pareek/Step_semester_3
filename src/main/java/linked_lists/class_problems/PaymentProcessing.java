import java.util.Scanner;
// Time: O(n) to process all payments.
public class PaymentProcessing {
    interface PaymentMode { double processPayment(double amount); String name(); }
    static class CashPayment implements PaymentMode {
        public double processPayment(double a) { return a; }
        public String name() { return "Cash"; }
    }
    static class CardPayment implements PaymentMode {
        public double processPayment(double a) { return a + a * 0.02; }
        public String name() { return "Card"; }
    }
    static class UpiPayment implements PaymentMode {
        public double processPayment(double a) { return a; }
        public String name() { return "UPI"; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PaymentMode[] modes = new PaymentMode[n]; double[] amt = new double[n];
        for (int i = 0; i < n; i++) {
            String m = sc.next(); amt[i] = sc.nextDouble();
            modes[i] = m.equals("Card") ? new CardPayment() : m.equals("UPI") ? new UpiPayment() : new CashPayment();
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double processed = modes[i].processPayment(amt[i]);
            System.out.println(modes[i].name() + ": amount " + amt[i] + ", fee " + (processed - amt[i]) + ", processed " + processed);
            total += processed;
        }
        System.out.println("Total Amount Processed: " + total);
    }
}