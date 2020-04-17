class Solution {
    
    // A bit optimized
    public boolean judgeSquareSum(int c) {
        int  sq = (int)Math.sqrt(c);
        int mul;
        for(int a = sq / 2; a <= sq;) {
            mul = a * a;
            if(isSquareRoot(c - (mul))) {
                return true;
            } else if(c - mul > 0) {
                a++;
            } else {
                a--;
            }
        }
        return false;
    }
    
    
    // Slower
    
    public boolean judgeSquareSum(int c) {
        int  sq = (int)Math.sqrt(c);
        for(int a = 0; a <= sq; a++) {
            if(isSquareRoot(c - (a * a))) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isSquareRoot(int num) {
        double ceil = Math.sqrt(num);
        return (ceil - Math.floor(ceil)) == 0;
    }
}
