

public class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int row = 1; row < matrix.length; row++) {
            for(int col = 1; col < matrix[1].length; col++) {
                if(matrix[row][col] != matrix[row - 1][col - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
