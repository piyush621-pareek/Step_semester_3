class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            this.basicSalary = 0;
            System.out.println("Warning: Basic salary cannot be negative. Setting to 0.");
        } else {
            this.basicSalary = openingBasicSalary;
        }
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Bonus amount must be greater than zero.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Error: Tax percentage must be between 0 and 100.");
        } else {
            double taxAmount = this.basicSalary * (percent / 100);
            this.basicSalary -= taxAmount;
            System.out.println("Tax deducted: " + (int)percent + "%");
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class PayrollDemo {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}