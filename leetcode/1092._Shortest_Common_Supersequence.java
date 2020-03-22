

public class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char []first = str1.toCharArray();
        char []second = str2.toCharArray();
        int [][]dpSol = new int[n + 1][m + 1];
        
        findLongestSubseq(dpSol, first, second, n, m);
        int fi = n;
        int si = m;
        StringBuilder sb = new StringBuilder();
        while(fi > 0 && si > 0) {
            if(first[fi - 1] == second[si - 1]) {
                sb.append(first[fi - 1]);
                --fi;
                --si;
            } else if(dpSol[fi - 1][si] > dpSol[fi][si - 1]) {
                sb.append(first[fi - 1]);
                --fi;
            } else {
                sb.append(second[si - 1]);
                --si;
            }
        }
 //       System.out.println(sb.toString());
        
        while(fi > 0) {
            sb.append(first[fi - 1]);
            --fi;
        }
        while(si > 0) {
            sb.append(second[si - 1]);
            --si;
        }
        return sb.reverse().toString();
    }
    
    public void findLongestSubseq(int [][]dpSol, char []first, char []second, int n, int m) {
        for(int fi = 1; fi <= n; fi++) {
            for(int si = 1; si <= m; si++) {
                if(first[fi - 1] == second[si - 1]) {
                    dpSol[fi][si] = 1 + dpSol[fi -1][si - 1];
                } else {
                    dpSol[fi][si] = Math.max(dpSol[fi -1][si], dpSol[fi][si - 1]);
                }
            }
        }
    }
}
