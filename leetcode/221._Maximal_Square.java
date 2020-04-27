class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int max = 0;
        
        int n = matrix[0].length;
        int[][] dp = new int[2][n];
        int id = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 || j==0){
                    dp[id][j] = matrix[i][j] == '0' ? 0 : 1;
                }
                else if(matrix[i][j] == '1'){
                    // int a = r[0][j];
                    // int b = r[0][j-1];
                    // int c = r[1][j-1];
                    int min = Math.min(dp[1-id][j], Math.min(dp[1-id][j-1],dp[id][j-1]));
                    dp[id][j] = min+1;
                } else {
                    dp[id][j] = 0;
                }
                max = Math.max(dp[id][j], max);
            }
            id = 1 ^ id;
        }
        // System.out.println(Arrays.deepToString(dp));
        return max*max;
    }
}
