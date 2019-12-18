

public class Solution {

public int oddCells(int n, int m, int[][] indices) {
        boolean []rows = new boolean[n];
        boolean []cols = new boolean[m];
        
        for(int []index : indices) {
            rows[index[0]] = !rows[index[0]];
            cols[index[1]] = !cols[index[1]];
        }
        
        int count = 0;
        for(int index = 0; index < n; index++) {
            for(int col = 0; col < m; col++) {
                if((rows[index] ^ cols[col])) {
                    count++;
                }
            }
        }
        return count;
    }
}
