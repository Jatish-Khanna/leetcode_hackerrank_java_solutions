class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return x;
        }
        long start = 1;
        long end = x;
        long mid;
        long mul;
        long ans = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            mul = mid * mid;
            if(mul == x) {
                return (int)mid;
            } else if(mul < x) {
                ans = mid;
                start = mid + 1;
                
            } else {
                end = mid - 1;
            }
        }
        return (int)ans;
    }
}
