

public class Solution {

// Both the solution use same memory and CPU cycles

    public int hammingDistance(int x, int y) {
        
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistanceWithBitOperation(int x, int y) {
        int diff = x ^ y;
        int count = 0;
        while(diff > 0) {
            diff = diff & (diff - 1);
            count++;
        }
        return Integer.bitCount(x ^ y);
    }
}
