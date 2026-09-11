import java.util.Scanner;

public class WordReversalEncoder {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            reversedSentence.append(wordBuilder.reverse().toString());
            
            if (i < words.length - 1) {
                reversedSentence.append(" ");
            }
        }
        return reversedSentence.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence to reverse: ");
        String inputSentence = scanner.nextLine();
        
        System.out.println(reverseEachWord(inputSentence));
        
        scanner.close();
    }
}