import java.util.*;

public class WordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        List<String> stopWordsList = Arrays.asList("the", "was", "and", "a", "is", "of", "in");
        Set<String> stopWords = new HashSet<>(stopWordsList);
        
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedText.split("\\s+");
        
        Map<String, Integer> wordCounts = new HashMap<>();
        
        for (String word : words) {
            if (word.isEmpty() || stopWords.contains(word)) {
                continue;
            }
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCounts.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter feedback paragraph: ");
        String feedback = scanner.nextLine();
        
        printFilteredWordFrequency(feedback);
        
        scanner.close();
    }
}