class Solution {
    public int findComplement(int num) {
        int n = num;
        if(num == 0) {
            return 1;
        }
        int ones = 0;
        while(n > 0) {
            n = n >> 1;
            ones = ones << 1 | 1;
        }
        // System.out.println(Integer.toBinaryString(ones) + " " + Integer.toBinaryString(num));
        return ones ^ num;
    }
    
    
    public int findComplement(int num) {
        int n = num;
        if(num == 0) {
            return 1;
        }
        int ones = 1;
        while(n > 0) {
            n = n >> 1;
            ones = ones << 1;
        }
        // System.out.println(Integer.toBinaryString(ones - 1) + " " + Integer.toBinaryString(num));
        return (ones - 1) ^ num;
    }
}
