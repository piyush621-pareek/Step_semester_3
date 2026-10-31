import java.util.Arrays;
public class RemoveDuplicatesSorted {
    // Two pointers, in place: O(n) time, O(1) extra space (no second array).
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;                               // next slot for a unique value
        for (int i = 1; i < nums.length; i++)
            if (nums[i] != nums[k - 1]) nums[k++] = nums[i];
        return k;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int len = removeDuplicates(nums);
        System.out.println("length = " + len);
        System.out.println("nums[0.." + (len - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, len)));
    }
}