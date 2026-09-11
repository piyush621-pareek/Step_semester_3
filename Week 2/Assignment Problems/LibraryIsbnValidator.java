import java.util.Scanner;

public class LibraryIsbnValidator {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        }
        return trimmed.toUpperCase();
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        StringBuilder displayLine = new StringBuilder();
        displayLine.append("[").append(code.substring(0, 3)).append("] ")
                   .append("YEAR: ").append(code.substring(3, 7))
                   .append(" | CATALOG: ").append(code.substring(7));
                   
        return displayLine.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ISBN code: ");
        String rawInput = scanner.nextLine();
        
        String normalizedCode = normalizeCode(rawInput);
        System.out.println(validateAndFormat(normalizedCode));
        
        scanner.close();
    }
}