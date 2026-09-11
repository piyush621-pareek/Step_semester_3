import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage); 
    }
}

public class Problem5 {
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable[count++] = p;
            }
        }
        
        Player[] finalDraft = Arrays.copyOf(draftable, count);
        Arrays.sort(finalDraft);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < finalDraft.length; i++) {
            sb.append(i + 1).append(". ").append(finalDraft[i].name);
            if (i < finalDraft.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of players: ");
        int n = sc.nextInt();
        Player[] players = new Player[n];
        
        System.out.println("For each player, enter: Name Matches Average Injured(true/false)");
        for (int i = 0; i < n; i++) {
            players[i] = new Player(sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextBoolean());
        }
        System.out.println(draftAndRank(players));
    }
}