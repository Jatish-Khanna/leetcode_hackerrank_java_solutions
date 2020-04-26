class Solution {

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][]visited = new boolean[n][m];
        int count = 0;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                if(!visited[row][col] && grid[row][col] == 0) {
                    if(dfs(grid, row, col, n, m, visited)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid, int i, int j, int n, int m, boolean[][] visited) {
        if(isinValid(i, j, n, m))
            return false;
        
        if(visited[i][j]) 
            return true;
        
        
        boolean up = true, down = true, left = true, right = true;
        if(grid[i][j] == 0 && !visited[i][j])
        {
            visited[i][j] = true;
            if(grid[i-1][j] == 1) up = true;
            else if(i-1 == 0) up = false;
            else up = up & dfs(grid,i-1,j,n,m,visited);
             
            if(grid[i+1][j] == 1) down = true;
            else if(i+1 == grid.length-1) down = false;
            else down = down & dfs(grid,i+1,j,n,m,visited);
             
            if(grid[i][j-1] == 1) left = true;
            else if(j-1 == 0) left = false; 
            else left = left & dfs(grid,i,j-1,n,m,visited);
             
            if(grid[i][j+1] == 1) right = true;
            else if(j+1 == grid[0].length-1) right = false; 
            else right = right & dfs(grid,i,j+1,n,m,visited);
        }
        return up && down && left && right;
    }
    
    private boolean isinValid(int row, int col, int n, int m) {
        return row == 0 || row == n - 1 || col == 0 || col == m - 1;
    }
}
