import java.util.Scanner;
public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String w = sc.next();
            String rev = new StringBuilder(w).reverse().toString();
            System.out.println(rev + " - " + (w.equals(rev) ? "palindrome" : "not a palindrome"));
        }
    }
}