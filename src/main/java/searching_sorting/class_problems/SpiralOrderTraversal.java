import java.util.ArrayList;
import java.util.List;
public class SpiralOrderTraversal {
    // Time O(m*n), output Space O(m*n).
    static List<Integer> spiralOrder(int[][] g) {
        List<Integer> out = new ArrayList<>();
        int top = 0, bottom = g.length - 1, left = 0, right = g[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) out.add(g[top][c]);
            top++;
            for (int r = top; r <= bottom; r++) out.add(g[r][right]);
            right--;
            if (top <= bottom) { for (int c = right; c >= left; c--) out.add(g[bottom][c]); bottom--; }
            if (left <= right) { for (int r = bottom; r >= top; r--) out.add(g[r][left]); left++; }
        }
        return out;
    }
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}