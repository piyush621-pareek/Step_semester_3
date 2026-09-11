import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = s.nextInt();
        int originalNumber = number;
        int reverseNumber = 0;

        while (number != 0) {
            int lastdigit = number % 10;
            reverseNumber = reverseNumber * 10 + lastdigit;
            number = number / 10;
        }

        if (originalNumber == reverseNumber) {
            System.out.println(originalNumber + " is a palindrome.");
        } else {
            System.out.println(originalNumber + " is not a palindrome.");
        }
        s.close();
    }

    
}