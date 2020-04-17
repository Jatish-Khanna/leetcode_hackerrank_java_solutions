class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int [][]result = new int[R*C][2];
        int index = 0;
        result[index++] = new int[]{r0, c0};
        int rc = r0;
        int cc = c0;
        int [][]dir = {{0, 1, 1}, {1, 0, 0}, {0, -1, 1}, {-1, 0, 0}};
        int length = 0;
        int directionIndex = 0;
        while(index < result.length) {
            
            length += dir[directionIndex][2];
            
            
            
            for(int len = 1; len <= length && index < result.length; len++) {
                
//                System.out.println(rc + " " + cc);
                rc += dir[directionIndex][0];
                cc += dir[directionIndex][1];
                
                if(isValid(rc,cc, R, C)) {
                    result[index++] = new int[]{rc, cc};
                }
            }
            directionIndex = (directionIndex + 1) % dir.length;
        }
        return result;
    }
    
    private boolean isValid(int rr, int cc, int R, int C) {
        return rr >= 0 && rr < R && cc >= 0 && cc < C;
    }
}
