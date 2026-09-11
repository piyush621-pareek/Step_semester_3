import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine();
        
        char result = findFirstNonRepeatingChar(text);
        
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        
        scanner.close();
    }

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return '\0'; // Return null character if none found
    }
}