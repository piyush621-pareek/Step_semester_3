import java.util.Arrays;
import java.util.Scanner;

// Implements Comparable so Arrays.sort(...) can handle descending composite score ranking natively
class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;
    double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        // Derived from the problem's example output
        this.compositeScore = (cgpa * 10) + (codingScore * 0.5); 
    }

    @Override
    public int compareTo(Candidate other) {
        // Sort in descending order based on composite score
        return Double.compare(other.compositeScore, this.compositeScore);
    }
}

public class RankingEngine {

    // Overloaded check for pure CGPA eligibility
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5; 
    }

    // Overloaded check for borderline CGPA with strong coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60; 
    }

    static String shortlistAndRank(Candidate[] candidates) {
        // First pass: Count eligible candidates
        int eligibleCount = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                eligibleCount++;
            }
        }

        // Second pass: Extract them into a perfectly sized array
        Candidate[] shortlisted = new Candidate[eligibleCount];
        int index = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted[index++] = c;
            }
        }

        // Java's built-in sort utilizes Candidate's compareTo method
        Arrays.sort(shortlisted);

        // Build the formatted string output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append(i + 1).append(". ")
              .append(shortlisted[i].name).append(" (")
              .append(shortlisted[i].compositeScore).append(")");
            
            if (i < shortlisted.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of candidates: ");
        int n = Integer.parseInt(scanner.nextLine());
        
        Candidate[] candidates = new Candidate[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter details for candidate " + (i + 1) + " (Name CGPA CodingScore): ");
            String[] parts = scanner.nextLine().split(" ");
            String name = parts[0];
            double cgpa = Double.parseDouble(parts[1]);
            int codingScore = Integer.parseInt(parts[2]);
            
            candidates[i] = new Candidate(name, cgpa, codingScore);
        }
        
        System.out.println(shortlistAndRank(candidates));
        
        scanner.close();
    }
}
