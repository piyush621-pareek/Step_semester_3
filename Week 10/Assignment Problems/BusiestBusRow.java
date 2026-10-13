public class BusiestBusRow {
    // Time: O(r*c), Space: O(1).
    static void busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = -1;
        for (int r = 0; r < grid.length; r++) {
            int total = 0;
            for (int c = 0; c < grid[r].length; c++) total += grid[r][c];
            if (total > bestTotal) { bestTotal = total; bestRow = r; }  // strictly larger -> ties keep smaller index
        }
        System.out.println("Row " + bestRow + ", Total " + bestTotal);
    }
    public static void main(String[] args) {
        int[][] grid = {{2, 0, 1}, {3, 3, 1}, {1, 1, 1}};
        busiestRow(grid);
    }
}