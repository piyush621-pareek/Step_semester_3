public class TwoSum {
    public static int[] findNumbers(int[]nums ,  int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target)) {
                    return new int[] {i, j};
                }
            }
        }return new int[]{};
    }
    public static void main(String[] args) {
        int [] nums = {7, 2, 5, 3};
        int target = 9;
        int[] result = findNumbers(nums, target);
        System.out.println(result[0] + " ," + result[1]);
    }
}