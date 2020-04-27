class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int num;
        // int max;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        
         for(int i = 0; i < m; i++) {
            num = Integer.MAX_VALUE;
            // max = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++) {
                num = Math.min(num, matrix[i][j]);
            }
             set.add(num);
        }
        
        
         for(int i = 0; i < n; i++) {
            // num = Interger.MAX_VALUE;
            num = Integer.MIN_VALUE;
            for(int j = 0; j < m; j++) {
                num = Math.max(num, matrix[j][i]);
            }
            if(set.contains(num)) {
                list.add(num);
            }
        }
        return list;
    }
}
