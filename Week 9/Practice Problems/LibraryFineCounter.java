import java.util.Scanner;

abstract class LibraryItem {
    private final String title;
    protected final int daysLate;
    protected LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
    public String getTitle() { return title; }
    public abstract double fine();
}

class Book extends LibraryItem {
    public Book(String t, int d) { super(t, d); }
    public double fine() { return 2.0 * daysLate; }
}

class Dvd extends LibraryItem {
    public Dvd(String t, int d) { super(t, d); }
    public double fine() { return Math.min(5.0 * daysLate, 50.0); }   // capped at 50
}

class Magazine extends LibraryItem {
    public Magazine(String t, int d) { super(t, d); }
    public double fine() { return 1.0 * daysLate; }
}

public class LibraryFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            int d = Integer.parseInt(t[2]);
            LibraryItem it;
            switch (t[0]) {
                case "BOOK":     it = new Book(t[1], d); break;
                case "DVD":      it = new Dvd(t[1], d); break;
                default:         it = new Magazine(t[1], d);
            }
            total += it.fine();
            System.out.printf("%s: %.2f%n", it.getTitle(), it.fine());
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}