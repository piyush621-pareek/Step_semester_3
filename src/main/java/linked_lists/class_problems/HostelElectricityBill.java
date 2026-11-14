import java.util.Scanner;
// Time: O(n) to bill all rooms.
public class HostelElectricityBill {
    static int bill(int u) {
        int b;
        if (u <= 100) b = u * 3;
        else if (u <= 200) b = 300 + (u - 100) * 5;
        else b = 300 + 500 + (u - 200) * 8;
        return b + 50;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), billed = 0, total = 0;
        for (int i = 0; i < n; i++) {
            String room = sc.next(); int u = sc.nextInt();
            if (u < 0) { System.out.println(room + ": invalid reading"); continue; }
            int b = bill(u); billed++; total += b;
            System.out.println(room + ": " + u + " units, bill " + b);
        }
        System.out.println("Rooms billed " + billed + ", total " + total);
    }
}