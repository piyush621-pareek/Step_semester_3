
public class PiggyBank {

    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;      // new piggy bank starts at 0
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        // reject a withdrawal larger than current savings
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
        // otherwise: do nothing, savings stays the same
    }

    public double getSavings() {   // read-only access
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        System.out.println("ID: " + pb.getId() + ", start savings = " + pb.getSavings());

        pb.deposit(100);
        System.out.println("After deposit(100)  -> savings = " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdraw(30)  -> savings = " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("After withdraw(500) -> rejected, savings = " + pb.getSavings());
    }
}
