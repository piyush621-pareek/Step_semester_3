
import java.util.*;

/**
 * Problem 4: The Festival Bonus Calculator (no custom input — data hardcoded)
 *
 * Polymorphism: employees share name + salary and a common bonus() operation,
 * but each type computes the bonus its own way. Payroll processes all employees
 * uniformly.
 */
public class A_Problem4_FestivalBonus {

    abstract static class Employee {

        protected String name;
        protected double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        abstract double bonus();
    }

    static class FullTime extends Employee {

        FullTime(String n, double s) {
            super(n, s);
        }

        double bonus() {
            return salary * 0.10;
        }     // 10% of salary
    }

    static class PartTime extends Employee {

        PartTime(String n, double s) {
            super(n, s);
        }

        double bonus() {
            return salary * 0.05;
        }     // 5% of salary
    }

    static class Intern extends Employee {

        Intern(String n, double s) {
            super(n, s);
        }

        double bonus() {
            return 2000;
        }              // fixed ₹2,000
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<Employee> employees = Arrays.asList(
                new FullTime("Asha", 50000),
                new PartTime("Ravi", 30000),
                new Intern("Neha", 15000)
        );

        double total = 0;
        for (Employee e : employees) {        // uniform processing
            double b = e.bonus();
            total += b;
            System.out.printf("%s: %.2f%n", e.name, b);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
