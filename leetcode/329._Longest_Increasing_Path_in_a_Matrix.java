

public class Solution {


    private int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) { return 0; }
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int [][]incMatrix = new int[rows][cols];
        int result = 0;
        
        for(int rIndex = 0; rIndex < rows; rIndex++) {
            for(int colIndex = 0; colIndex < cols; colIndex++) {
                if(incMatrix[rIndex][colIndex] == 0) {
                    result = Math.max(result, dfs(rIndex, colIndex, rows, cols, matrix, incMatrix));
                }
            }
        }
        return result;
    }
    
    public int dfs(int rIndex, int colIndex, int rows, int cols, int [][]matrix, int [][]incMatrix) {
        if(incMatrix[rIndex][colIndex] != 0) { return incMatrix[rIndex][colIndex]; }
        
        int result = 1;
        
        for(int []direction : directions) {
            int nRow = rIndex + direction[0];
            int nCol = colIndex + direction[1];
            if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && matrix[rIndex][colIndex] < matrix[nRow][nCol]) {
                result = Math.max(result, 1 + dfs(nRow, nCol, rows, cols, matrix, incMatrix));
            }
        }
        
        incMatrix[rIndex][colIndex] = result;
        return result;
    }
}
