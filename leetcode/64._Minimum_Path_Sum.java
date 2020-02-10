

public class Solution {

    public int minPathSum(int[][] grid) {
        int [][]sol = new int[grid.length][grid[0].length];
        
        sol[0][0] = grid[0][0];
        for(int row = 1; row < grid.length; row++) {
            sol[row][0] = grid[row][0] + sol[row - 1][0];    
        }
        for(int col = 1; col < grid[0].length; col++) {
            sol[0][col] = grid[0][col] + sol[0][col - 1];    
        }
        
        for(int row = 1; row < grid.length; row++) {
            for(int col = 1; col < grid[0].length; col++) {
                sol[row][col] = Math.min(sol[row - 1][col], sol[row][col - 1]) + grid[row][col];
            }
        }
        return sol[grid.length - 1][grid[0].length - 1];
    }
}
