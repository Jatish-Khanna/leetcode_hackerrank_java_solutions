

public class Solution {


    public int minCostClimbingStairs(int[] cost) {
        
        
        //int steps[] = new int[cost.length  + 1];
        int min1 = 0;
        int min2 = 0;
        int oldMin;

        for(int index = 0; index < cost.length - 1; index++) {
            oldMin = min2;
            min2 = Math.min(min1 + cost[index], min2 + cost[index + 1]);
            min1 = oldMin;
        }
        return min2;
    }
}
