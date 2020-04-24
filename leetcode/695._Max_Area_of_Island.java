class Solution {
    int [][]dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][]visited = new boolean[n][m];
        int max = 0;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(!visited[row][col] && grid[row][col] == 1) {
                    max = Math.max(dfs(row, col, n, m,  visited, grid), max);
                }
            }
        }
        return max;
    }
    
    private int dfs(int row, int col, int n, int m, boolean [][]visited, int [][]grid) {
        visited[row][col] = true;
        int max = 0;
        int []ar;
        for(int index = 0; index < dir.length; index++) {
            ar = dir[index];
            if(isValid(row + ar[0], col + ar[1], n, m, visited, grid)) {
                max += dfs(row + ar[0], col + ar[1], n, m, visited, grid);
            } 
        }
        return max + 1;
    }
    
    private boolean isValid(int row, int col, int n, int m, boolean [][]visited, int [][]grid) {
        return row >= 0 && row < n && col >= 0 && col < m && !visited[row][col] && grid[row][col] == 1;
    }
}
