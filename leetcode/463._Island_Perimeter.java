class Solution {
    // 01 10 0-1 -10
    public int islandPerimeter(int[][] grid) {
            int perimter = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    perimter+= 4;
                    if(i>0 && grid[i-1][j] == 1){
                        perimter-=2;
                    }
                    if(j>0 && grid[i][j-1] == 1){
                        perimter-=2;
                    }
                }
            }
        }
        return perimter;
    }

    
    
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
