public class SearchInsertPosition {
    // Binary search: O(log n) time, O(1) space -> scales to very large arrays.
    static int searchInsertPosition(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1; else hi = mid - 1;
        }
        return lo;   // insertion point
    }
    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 2));
    }
}