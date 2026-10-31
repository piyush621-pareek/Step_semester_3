import java.util.HashSet;
public class PairWithTargetSum {
    // Approach 1 (brute force): check every pair -> O(n^2) time, O(1) space.
    // Approach 2 (used here): HashSet of seen values -> O(n) time, O(n) space.
    // Approach 3: sort + two pointers -> O(n log n) time, O(1) extra space.
    static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(target - x)) return true;
            seen.add(x);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasPairWithSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(hasPairWithSum(new int[]{3, 4, 6}, 20));
    }
}