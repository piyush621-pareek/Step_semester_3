import java.util.Scanner;

public class PrimeNumber { 
    public static void main (String[] args){ 
        boolean isPrime = true; 
        Scanner s = new Scanner(System.in); 
        
        System.out.println("Enter the number: "); 
        int number = s.nextInt(); 
        
        // Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            isPrime = false;
        } else {
            // Check for factors up to the square root of the number
            for(int i = 2; i <= Math.sqrt(number); i++) { 
                if (number % i == 0){ 
                    isPrime = false; 
                    break; // Exit loop early if a factor is found
                } 
            } 
        }
        
        System.out.println("Is the number " + number + " a Prime number? " + isPrime); 
        s.close();
    } 
}
