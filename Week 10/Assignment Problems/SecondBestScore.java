public class SecondBestScore {
    // Time: O(n), Space: O(1). Sorting would be O(n log n); one pass is faster and needs no sort.
    static int secondHighest(int[] scores) {
        int highest = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int s : scores) {
            if (s > highest) { second = highest; highest = s; }
            else if (s < highest && s > second) { second = s; }   // distinct, below highest
        }
        return (second == Integer.MIN_VALUE) ? -1 : second;
    }
    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60}));
        System.out.println(secondHighest(new int[]{50, 50, 50}));
    }
}