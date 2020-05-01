class Solution {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int [][]res = new int[n][m];
        
        for(int i = 0; i < m; i++) {
            for(int col = 0; col < n; col++) {
                res[col][i] = A[i][col];
            }
        }
        return res;
    }
}
