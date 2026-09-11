import java.util.Scanner;

public class InventoryBalancer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items in each section: ");
        int items = scanner.nextInt();
        
        int[] secA = new int[items];
        int[] secB = new int[items];
        
        System.out.println("Enter quantities for Section A (space-separated):");
        for (int i = 0; i < items; i++) {
            secA[i] = scanner.nextInt();
        }
        
        System.out.println("Enter quantities for Section B (space-separated):");
        for (int i = 0; i < items; i++) {
            secB[i] = scanner.nextInt();
        }

        analyzeInventory(secA, secB);
        scanner.close();
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        int maxQuantity = -1;
        String maxSection = "";
        int maxIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1; // 1-based index
            }
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1; // 1-based index
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: " + status);
        System.out.println("Highest Quantity: " + maxQuantity + " (" + maxSection + ", Item " + maxIndex + ")");
    }
}