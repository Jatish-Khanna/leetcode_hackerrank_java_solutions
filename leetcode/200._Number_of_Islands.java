
public class Solution {

    
    private static final int []rDir = {-1, 0, 0, 1};
    private static final int []cDir = {0, -1, 1, 0};
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) { return 0;}
        int rows = grid.length;
        int cols = grid[0].length;
        boolean [][]visited = new boolean[rows][cols];
        int islandCount = 0;
        for(int rIndex = 0; rIndex < rows; rIndex++) {
            for(int cIndex = 0; cIndex < cols; cIndex++) {
                if(!visited[rIndex][cIndex] && grid[rIndex][cIndex] == '1') {
                    visit(rIndex, cIndex, visited, grid, rows, cols);
                    islandCount++;
                }
                
            }
        }
        return islandCount;
    }
    
    public void visit(int rIndex, int cIndex, boolean [][]visited, char [][]grid, int rows, int cols) {
        visited[rIndex][cIndex] = true;
        for(int index = 0; index < rDir.length; index++) {
            if(valid(rIndex + rDir[index], cIndex + cDir[index], visited, grid, rows, cols)) {
                visit(rIndex + rDir[index], cIndex + cDir[index], visited, grid, rows, cols);
            }
        }
    }
    
    
    public boolean valid(int rIndex, int cIndex, boolean [][]visited, char [][]grid, int rows, int cols) {
        
        return rIndex >= 0 && rIndex < rows && cIndex >= 0 && cIndex < cols  && grid[rIndex][cIndex] == '1' && !visited[rIndex][cIndex];
    }

}
