public class PairSumSorted {
    // Two pointers on sorted data: O(n) time, O(1) space. Ignoring the order (all pairs) is O(n^2).
    static String pairSumSorted(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) return "(" + nums[i] + ", " + nums[j] + ")";
            if (sum < target) i++; else j--;
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        System.out.println(pairSumSorted(new int[]{-4, -1, 0, 3, 5, 9}, 4));
        System.out.println(pairSumSorted(new int[]{1, 2, 3}, 100));
    }
}