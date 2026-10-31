import java.util.Arrays;
public class LibraryBookShelf {
    // Insertion sort; prints the shelf after each book from the second onwards.
    static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;
            while (j >= 0 && books[j] > key) {   // shift bigger books right
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;                  // drop new book into the gap
            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }
    public static void main(String[] args) {
        shelf(new int[]{30, 10, 40, 20});
        shelf(new int[]{5, 3, 1});                // own test input
    }
}