import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the original text: ");
        String original = scanner.nextLine();

        System.out.print("Enter the typed text: ");
        String typed = scanner.nextLine();

        if (original.length() == typed.length()) {
            checkTypingAccuracy(original, typed);
        } else {
            System.out.println("Error: The typed string must be the exact same length as the original string.");
        }
        
        scanner.close();
    }

    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchIndex = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchIndex == -1) {
                firstMismatchIndex = i;
            }
        }

        double accuracy = ((double) matched / original.length()) * 100;
        
        // Output formatting
        if (firstMismatchIndex == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", 
                              matched, original.length(), accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n",
                    matched, original.length(), accuracy, 
                    (firstMismatchIndex + 1), // 1-based indexing for user output
                    original.charAt(firstMismatchIndex), 
                    typed.charAt(firstMismatchIndex));
        }
    }
}