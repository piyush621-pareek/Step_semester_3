import java.util.Scanner;
public class DigitSumReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0, rev = 0, temp = n;
        while (temp > 0) {
            int d = temp % 10;
            sum += d;
            rev = rev * 10 + d;
            temp /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
    }
}