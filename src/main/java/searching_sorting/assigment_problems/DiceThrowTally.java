import java.util.Arrays;
public class DiceThrowTally {
    // Counting sort for values 1..6: O(n) time, no comparisons.
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];                // count[v] = times v was thrown
        for (int r : rolls) count[r]++;
        StringBuilder sb = new StringBuilder("Counts:");
        for (int v = 1; v <= 6; v++) sb.append(" ").append(v).append(":").append(count[v]);
        System.out.println(sb);
        int[] result = new int[rolls.length];
        int k = 0;
        for (int v = 1; v <= 6; v++)
            for (int c = 0; c < count[v]; c++) result[k++] = v;
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Sorted: " + Arrays.toString(diceSort(new int[]{4, 1, 2, 6, 4, 1, 4})));
        System.out.println("Sorted: " + Arrays.toString(diceSort(new int[]{6, 5, 6})));   // own test
    }
}