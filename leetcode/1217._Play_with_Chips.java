

public class Solution {
    public int minCostToMoveChips(int[] chips) {
        if(chips.length == 0) { return 0; }
        int even = 0 , odd = 0;
        
        for(int element : chips) {
            if(element % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
