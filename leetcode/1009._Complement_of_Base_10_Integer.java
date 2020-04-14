

public class Solution {

    public int bitwiseComplement(int N) {
        int num = N;
        if(N == 0) {
            return 1;
        }
        
        int set = 1 << 30;
        
        
        while((num & set) == 0) {
            set = set >> 1;
        }
        // All set bits
        set = (set << 1) - 1;
        
        
        return set ^ num;
    }
}
