import java.util.Scanner;

public class FileValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filename:");
        String filename = scanner.nextLine();
        System.out.println(validateFileExtension(filename));
        scanner.close();
    }

    public static String validateFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        
        String extension = filename.substring(lastDotIndex + 1);
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        
        return "Rejected — invalid file type";
    }
}