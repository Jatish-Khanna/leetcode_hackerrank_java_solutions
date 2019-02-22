class Solution {

    public void setZeroes(int[][] matrix) {
        
        int rows[] = new int[matrix.length];
        Arrays.fill(rows, 1);
        
        int cols[] = new int[matrix[0].length];
        Arrays.fill(cols, 1);
        
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0) {
                    rows[row] = 0;
                    cols[col] = 0;
                }
            }
        }
        
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(rows[row] == 0 || cols[col] == 0) {
                    matrix[row][col] = 0;
              //      matrix[0][col] = 0;
                }
            }
        }
    }
}
