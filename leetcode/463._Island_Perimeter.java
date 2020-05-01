class Solution {
    // 01 10 0-1 -10
    public int islandPerimeter(int[][] grid) {
        int per = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1) {
                    if(c == n - 1 || grid[r][c+1] == 0) {
                        per++;
                    }
                    if(r == m -1 || grid[r+1][c] == 0) {
                        per++;
                    }
                    if(c == 0 || grid[r][c-1] == 0) {
                        per++;
                    }
                    if(r == 0 || grid[r-1][c] == 0) {
                        per++;
                    }
                }
            }
        }
        return per;
    }
}
