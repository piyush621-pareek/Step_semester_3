import java.util.Scanner;

public class PhoneMasker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter phone number:");
        String phone = scanner.nextLine();
        System.out.println(maskPhoneNumber(phone));
        scanner.close();
    }

    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append("-");
        masked.append(phone.substring(6));
        
        return masked.toString();
    }
}