import java.util.Scanner;
public class Gcd {
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number 1");
        int number1 = s.nextInt();
        System.out.println("Enter the number 2");
        int number2 = s.nextInt();

        while(number2 !=0){
            int remainder = number1 % number2;
            number1 = number2;
            number2 = remainder;
        }
        System.out.println("GCD is: " + number1);
        s.close();
    }
    
}
