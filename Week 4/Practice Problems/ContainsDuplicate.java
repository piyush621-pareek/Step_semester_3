public class ContainsDuplicate {
    public static boolean findDuplicate(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    System.out.println("DUPLICATE ELEMENTS: " + input[i]);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [] input = {1, 2, 3, 4, 2};
        boolean result = findDuplicate(input);
        System.out.println(result);
    }
}
