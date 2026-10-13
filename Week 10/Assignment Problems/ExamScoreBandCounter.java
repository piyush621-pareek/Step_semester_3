public class ExamScoreBandCounter {
    // Linear scan: O(n). This solution: O(log n) via two binary searches. Space O(1).
    // first index with scores[i] >= target
    static int lowerBound(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) { int mid = (lo + hi) / 2; if (a[mid] < target) lo = mid + 1; else hi = mid; }
        return lo;
    }
    static int countInBand(int[] scores, int low, int high) {
        int start = lowerBound(scores, low);       // first score >= low
        int end = lowerBound(scores, high + 1);    // first score > high
        return end - start;                        // duplicates at the edges are included
    }
    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}