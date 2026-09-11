import java.util.Scanner;

public class DuplicateFinder {

    // Method to find the first duplicate using nested loops
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of registered teams: ");
        int n = Integer.parseInt(scanner.nextLine());
        
        String[] teamNames = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter team " + (i + 1) + " name: ");
            teamNames[i] = scanner.nextLine();
        }
        
        System.out.println(findDuplicateTeam(teamNames));
        
        scanner.close();
    }
}