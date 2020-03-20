

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][]dpSol = new int[n + 1][m + 1];
        
        for(int first = 0; first < n; first++) {
            for(int second = 0; second < m; second++) {
                if(text1.charAt(first) == text2.charAt(second)) {
                    dpSol[first + 1][second + 1] = 1 + dpSol[first][second];
                } else {
                    dpSol[first + 1][second + 1] = Math.max(dpSol[first + 1][second], dpSol[first][second + 1]);
                }
            }
        }
        return dpSol[n][m];
    }
}
