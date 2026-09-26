import java.time.LocalDate;
import java.util.*;

/**
 * Problem 2: Library Item Due Date Calculator  (no custom input — data hardcoded)
 *
 * Polymorphism: each LibraryItem knows its own borrowing period. The main
 * loop asks every item for its due date uniformly. Current date fixed at
 * 2023-10-26 per the problem.
 */
public class Problem2_LibraryDueDate {

    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    abstract static class LibraryItem {
        protected String title;
        LibraryItem(String title) { this.title = title; }
        abstract int loanPeriodDays();
        LocalDate dueDate() { return CURRENT_DATE.plusDays(loanPeriodDays()); }
    }

    static class Book extends LibraryItem {
        Book(String t) { super(t); }
        int loanPeriodDays() { return 14; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String t) { super(t); }
        int loanPeriodDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        Magazine(String t) { super(t); }
        int loanPeriodDays() { return 3; }
    }

    public static void main(String[] args) {
        // Hardcoded sample data
        List<LibraryItem> items = Arrays.asList(
            new Book("1984"),
            new Dvd("The Matrix"),
            new Magazine("Forbes Issue 500")
        );

        for (LibraryItem item : items) {      // uniform processing
            System.out.printf("%s: %s%n", item.title, item.dueDate());
        }
    }
}
