

public class Solution {

    int [][]dir = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        // count all the rotten
        for(int ri = 0; ri < grid.length; ri++) {
            for(int ci = 0; ci < grid[0].length; ci++) {
                if(grid[ri][ci] == 2) {
                    queue.offer(new int[]{ri,ci});
                } else if(grid[ri][ci] == 1) {
                    freshCount++;
                }
            }
        }
        // Optimization
        if(freshCount == 0) {
            return 0;
        } else if(queue.isEmpty()) {
            return -1;
        }

        
        int min = -1;
        int count;
        int []point;
        int nr, nc;
        
        while(!queue.isEmpty()) {
            count = queue.size();
            min++;
            while(count-- > 0) {
                point = queue.poll();        
                
                for(int []direction : dir) {
                    nr = point[0] + direction[0];
                    nc = point[1] + direction[1];
                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        queue.offer(new int[]{nr, nc});
                        grid[nr][nc] = 2; // Make it rotten
                        --freshCount; // already rotten
                    }
                }
            }
            
        }
        
        return freshCount == 0 ? min : -1;
    }
}
