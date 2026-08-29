import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or short phrase: ");
        String text = scanner.nextLine();

        boolean isIterative = isPalindromeIterative(text);
        boolean isRecursive = isPalindromeRecursive(text);
        boolean isArrayReversal = isPalindromeArrayReversal(text);

        System.out.print("Iterative: " + (isIterative ? "Palindrome" : "Not Palindrome"));
        System.out.print(" | Recursive: " + (isRecursive ? "Palindrome" : "Not Palindrome"));
        System.out.println(" | Array Reversal: " + (isArrayReversal ? "Palindrome" : "Not Palindrome"));
        
        scanner.close();
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        String reversed = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            reversed += arr[i];
        }
        return text.equals(reversed);
    }
}