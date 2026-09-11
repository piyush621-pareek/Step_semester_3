  import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = s.nextInt();
        int originalNumber = number;
        int sum = 0;

        while (number != 0) {
            int lastdigit = number % 10;
            sum = sum + (lastdigit * lastdigit *lastdigit);
            number = number / 10;

        }
        if (originalNumber == sum) {
            System.out.println(originalNumber + " is an Armstrong number.");
        } else {
            System.out.println(originalNumber + " is not an Armstrong number.");
        }
        s.close();
    }
    }