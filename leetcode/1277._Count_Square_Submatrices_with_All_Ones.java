

public class Solution {


    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][]dp  = new int [m][n];
        int count = 0;
        
        // row
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 1) {
                dp[i][0] = 1;
                count++;
            }
        }
        
        // col
        for(int i = 1; i < n; i++) {
            if(matrix[0][i] == 1) {
                dp[0][i] = 1;
                count++;
            }
        }
        //System.out.println(count);
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                //System.out.println(count);
                if(matrix[i][j] == 1) {
                    
                    dp[i][j] = 1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    count += dp[i][j];
                }
                
        
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return count;
    }
}
