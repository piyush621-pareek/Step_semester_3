import java.util.Scanner;

// The convenience fee lives in ONE place (base class). Abstract -> no plain "ticket" is sold.
abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20.0;
    protected final int count;
    protected Ticket(int count) { this.count = count; }
    protected abstract double pricePerSeat();   // changes per seat type
    protected abstract String seat();
    public double amount() { return count * (pricePerSeat() + CONVENIENCE_FEE); }
}

class RegularTicket extends Ticket {
    RegularTicket(int c) { super(c); }
    protected double pricePerSeat() { return 150; }
    protected String seat() { return "REGULAR"; }
}
class PremiumTicket extends Ticket {
    PremiumTicket(int c) { super(c); }
    protected double pricePerSeat() { return 250; }
    protected String seat() { return "PREMIUM"; }
}
class ReclinerTicket extends Ticket {
    ReclinerTicket(int c) { super(c); }
    protected double pricePerSeat() { return 400; }
    protected String seat() { return "RECLINER"; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            int c = Integer.parseInt(t[1]);
            Ticket tk;
            switch (t[0]) {
                case "REGULAR":  tk = new RegularTicket(c); break;
                case "PREMIUM":  tk = new PremiumTicket(c); break;
                default:         tk = new ReclinerTicket(c);
            }
            total += tk.amount();
            System.out.printf("%s: %.2f%n", tk.seat(), tk.amount());
        }
        System.out.printf("Total: %.2f%n", total);
    }
}