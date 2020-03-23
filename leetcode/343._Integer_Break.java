

public class Solution {


    public int integerBreak(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int []dpSol = new int[n + 1];
        dpSol[2] = 1;
        dpSol[3] = 2;
        for(int index = 4; index <= n; index++) {
            if(index % 3 == 0) {
                dpSol[index] = 3 * ((index - 3) < 4 ? (index - 3) : dpSol[index - 3]);
            } else {
                dpSol[index] = 2 * ((index - 2) < 4 ? (index - 2) : dpSol[index - 2]);
            }
        }
        
     return dpSol[n];
    }
}
