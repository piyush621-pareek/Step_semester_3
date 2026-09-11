import java.util.Scanner;

public class WordLengthProfiler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the movie review: ");
        String review = scanner.nextLine();

        classifyWordLengths(review);
        scanner.close();
    }

    public static void classifyWordLengths(String review) {
        // Split text by whitespace
        String[] words = review.split("\\s+");
        
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Strip out non-alphabetic characters (like punctuation) before counting length
            int len = word.replaceAll("[^a-zA-Z]", "").length(); 
            
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }
}