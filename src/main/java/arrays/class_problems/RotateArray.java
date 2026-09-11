public class RotateArray {

    public static int[] rotate(int[] input, int k) {
        int[] result = new int[input.length];
        k = k % input.length;

        for (int i = 0; i < input.length; i++) {
            int newPosition = (i + k) % input.length;
            result[newPosition] = input[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] result = rotate(input, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

