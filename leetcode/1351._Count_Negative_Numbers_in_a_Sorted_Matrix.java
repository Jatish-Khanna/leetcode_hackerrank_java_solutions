

public class Solution {
    // Optimized solution - better than last implementation
        public int countNegatives(int[][] grid) {
        int count = 0;
        //int row = 0;
        int cols = grid[0].length - 1;
        int mid;
        int left = 0;
        int right;
        int row = grid.length - 1;
        
        while(row >= 0 && left <= cols) {
            if(grid[row][left] >= 0) {
                right = cols;
                
                while(left <= right) {
                  mid = left + (right - left) / 2;    
                  if(grid[row][mid] >= 0) {
                      left = mid + 1;  
                  } else {
                      right = mid - 1;
                  }
                }
            }
            count += cols - left + 1;
            --row;
        }
        
        return count;
    }

    
    
    // clear optimization should be Binary search algo.
        public int countNegatives(int[][] grid) {
        int count = 0;
        //int row = 0;
        int cols = grid[0].length - 1;
        int mid;
        int left = 0;
        int right;
        
        for(int row = grid.length - 1; row >= 0; row--) {
            if(grid[row][0] < 0) {
                count += cols + 1;
            } else if(grid[row][cols] >= 0) {
                continue;
            } else {
                // left = 0;
                right = cols;
                
                while(left <= right) {
                  mid = left + (right - left) / 2;    
                  if(grid[row][mid] < 0) {
                      right = mid - 1;
                  } else {
                      left = mid + 1;
                  }
                }
                //System.out.println(count);
                count += cols - left + 1;
                //System.out.println(count);
                //left = left - 1;
            }
        }
        
        return count;
    }

    
    
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
