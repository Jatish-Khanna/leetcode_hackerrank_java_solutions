

public class Solution {
    
    // clear optimization should be Binary search algo.
    
    
    
    // slight better solution - search learnly from backwards
    
    
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int rid = grid.length - 1; rid >= 0; rid--) {
            for(int cid = grid[0].length - 1; cid >= 0; cid--) {
                if(grid[rid][cid] >= 0) {
                    break;
                }
                count++;
            }
        }
        return count;
    }
}
    
    // Non optimized solution - as the numbers are sorted should use binary search
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int rid = 0; rid < grid.length; rid++) {
            for(int cid = 0; cid < grid[0].length; cid++) {
                if(grid[rid][cid] < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
