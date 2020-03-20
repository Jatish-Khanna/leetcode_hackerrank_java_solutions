

public class Solution {

    public int climbStairs(int n) {
        int lastOne = 1;
        int lastTwo = 1;
        //int ways = 1;
        if(n < 2) { return 1; }
        
        
        
        for(int index = 2; index <= n; index++) {
            lastTwo = lastOne + lastTwo;
            lastOne = lastTwo - lastOne;
            //lastTwo = ways;
        }
        return lastTwo;
    }
}
