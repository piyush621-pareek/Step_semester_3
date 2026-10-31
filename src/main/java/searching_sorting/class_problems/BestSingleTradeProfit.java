public class BestSingleTradeProfit {
    // Single pass: O(n) time, O(1) space. Checking every pair is O(n^2) -> far too slow at scale.
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, best = 0;
        for (int p : prices) {
            if (p < minPrice) minPrice = p;
            else best = Math.max(best, p - minPrice);
        }
        return best;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}