public class WarehouseBinGridScan {
    // Time O(m*n), extra Space O(1).
    static void warehouseSummary(int[][] grid) {
        int total = 0, max = -1, mr = 0, mc = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > max) { max = grid[r][c]; mr = r; mc = c; } // strict > keeps first on ties
            }
        System.out.println("total = " + total + ", maxCoordinate = (" + mr + ", " + mc + ")");
    }
    public static void main(String[] args) {
        warehouseSummary(new int[][]{{4, 9, 2}, {7, 1, 6}, {3, 12, 5}});
    }
}