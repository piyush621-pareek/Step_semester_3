public class MergeSort {

    public static int[] merge(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[arrayOne.length + arrayTwo.length];
        int i = 0, j = 0, k = 0;
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) {
                result[k] = arrayOne[i];
                i++;
            }
            else {
                result[k] = arrayTwo[j];
                j++;
            }
            k++;
        }
        while ( i < arrayOne.length) {
            result[k] = arrayOne[i];
            i++;
            k++;
        }
        while ( j < arrayTwo.length) {
            result[k] = arrayTwo[j];
            j++;
            k++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arrayOne = {1, 3, 5};
        int[] arrayTwo = {2, 4, 6};
        int[] sorted = merge(arrayOne, arrayTwo);
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
    }
}
