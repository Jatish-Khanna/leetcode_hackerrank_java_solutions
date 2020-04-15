

public class Solution {

    public int binaryGap(int N) {
        int diff = 0;
        int index = 0;
        int lastIndex = 32;
        while(N > 0) {
            if((N & 1) == 1) {
                diff = Math.max(diff, index - lastIndex);
                lastIndex = index;
            }
            N = N >> 1;
            index++;
        }
        return diff;
    }
}
