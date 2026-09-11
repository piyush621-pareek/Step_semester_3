import java.util.Scanner;

public class CountUpToN {
    public static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer N: ");
        int n = scanner.nextInt();
        
        printNumbersUpToN(n);
        
        scanner.close();
    }
}