
import java.time.LocalDate;
import java.util.*;

/**
 * Problem 5: The Streaming Plan Renewal Reminder (no custom input — hardcoded)
 *
 * Polymorphism: each Plan type knows its own validity in days; renewalDate() is
 * shared. The system processes all subscribers uniformly.
 */
public class A_Problem5_StreamingRenewal {

    abstract static class Plan {

        protected String name;
        protected LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class BasicPlan extends Plan {

        BasicPlan(String n, LocalDate d) {
            super(n, d);
        }

        int validityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Plan {

        StandardPlan(String n, LocalDate d) {
            super(n, d);
        }

        int validityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Plan {

        PremiumPlan(String n, LocalDate d) {
            super(n, d);
        }

        int validityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<Plan> subscribers = Arrays.asList(
                new BasicPlan("Asha", LocalDate.parse("2024-01-15")),
                new StandardPlan("Ravi", LocalDate.parse("2024-02-01")),
                new PremiumPlan("Neha", LocalDate.parse("2024-03-10")),
                new BasicPlan("Kiran", LocalDate.parse("2024-12-20"))
        );

        for (Plan p : subscribers) {          // uniform processing
            System.out.printf("%s: %s%n", p.name, p.renewalDate());
        }
    }
}
