import java.util.Scanner;

// Common base type for every plot: shares the owner, forces subclasses
// to supply their own area() -> adding a new shape never touches the report code.
abstract class Plot {
    private final String owner;
    protected Plot(String owner) { this.owner = owner; }
    public String getOwner() { return owner; }
    public abstract double area();            // each shape calculates differently
    public abstract String shape();
}

class CirclePlot extends Plot {
    private final double radius;
    public CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }
    public double area() { return Math.PI * radius * radius; }
    public String shape() { return "CIRCLE"; }
}

class RectanglePlot extends Plot {
    private final double length, width;
    public RectanglePlot(String owner, double l, double w) { super(owner); length = l; width = w; }
    public double area() { return length * width; }
    public String shape() { return "RECTANGLE"; }
}

class TrianglePlot extends Plot {
    private final double base, height;
    public TrianglePlot(String owner, double b, double h) { super(owner); base = b; height = h; }
    public double area() { return 0.5 * base * height; }
    public String shape() { return "TRIANGLE"; }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            Plot p;
            switch (t[0]) {
                case "CIRCLE":    p = new CirclePlot(t[1], Double.parseDouble(t[2])); break;
                case "RECTANGLE": p = new RectanglePlot(t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3])); break;
                default:          p = new TrianglePlot(t[1], Double.parseDouble(t[2]), Double.parseDouble(t[3]));
            }
            total += p.area();
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.shape(), p.area());
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}