

public class Solution {

 
    public boolean isNStraightHand(int[] hand, int W) {
        int remainder = hand.length % W;
        if(remainder != 0) {
            return false;
        } else {
            int []bucket = new int[W];
            for(int element : hand) {
                bucket[element % W]++;
            }
            for(int index = 1; index < W; index++ ) {
                if(bucket[index - 1] != bucket[index]) {
                    return false;
                }
            }
            return true;
        }
    }
}
