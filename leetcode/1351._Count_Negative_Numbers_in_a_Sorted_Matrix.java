

public class Solution {
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
