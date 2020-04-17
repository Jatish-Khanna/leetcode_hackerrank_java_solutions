class Solution {
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
