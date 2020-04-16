

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minRows = m;
        int minCols = n;
        
        for(int []ar : ops) {
            minRows = Math.min(minRows, ar[0]);
            minCols = Math.min(minCols, ar[1]);
        }
        return minRows * minCols;
    }
}
