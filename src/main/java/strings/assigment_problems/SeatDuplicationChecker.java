import java.util.Scanner;

public class SeatDuplicationChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of seats: ");
        int n = scanner.nextInt();
        int[] seats = new int[n];

        System.out.println("Enter the seat numbers separated by space:");
        for (int i = 0; i < n; i++) {
            seats[i] = scanner.nextInt();
        }

        checkDuplicateSeats(seats);
        scanner.close();
    }

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean hasDuplicate = false;
        
        for (int i = 0; i < seatNumbers.length; i++) {
            boolean isAlreadyPrinted = false;
            
            // Prevent printing the same duplicate multiple times
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    isAlreadyPrinted = true;
                    break;
                }
            }
            
            if (!isAlreadyPrinted) {
                for (int j = i + 1; j < seatNumbers.length; j++) {
                    if (seatNumbers[i] == seatNumbers[j]) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        hasDuplicate = true;
                        break; 
                    }
                }
            }
        }
        
        if (!hasDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}