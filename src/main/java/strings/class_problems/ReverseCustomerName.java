import java.util.Scanner;

public class ReverseCustomerName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        
        String reversedName = reverseCustomerName(name);
        
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversedName);
        
        scanner.close();
    }

    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        String reversed = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }
        return reversed;
    }
}