

public class Solution {


    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        if(n == 0 || m == 0) return Math.max(n, m);
        
        char []f = word1.toCharArray();
        char []s = word2.toCharArray();
        int [][]dpSol = new int[n + 1][m + 1];
        
        for(int index = 0; index <= n; index++) {
            dpSol[index][0] = index;
        }
        
        
        for(int index = 0; index <= m; index++) {
            dpSol[0][index] = index;
        }
        
        
        for(int first = 1; first <= n ; first++) {
            for(int second = 1; second <= m; second++) {
                
                if(f[first - 1] == s[second - 1]) {
                    dpSol[first][second] = dpSol[first - 1][second - 1];
                } else {
                    dpSol[first][second] = 1 + Math.min(Math.min(dpSol[first][second - 1], dpSol[first - 1][second]), dpSol[first - 1][second - 1]);
                }
            }
        }
        return dpSol[n][m];
    }
}
