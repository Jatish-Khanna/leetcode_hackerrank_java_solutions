class Solution {
    public int countBinarySubstrings(String s) {
        char ch[] = s.toCharArray();   
        int prev = 1;
        int curr = 1;
        int result = 0;
        for(int i = 1; i < ch.length; i++) {
            if(ch[i] == ch[i-1]) {
                curr++;
            } else {
                prev = curr;
                curr = 1;   
            }
            
            if(prev >= curr) {
                result++;
            }
        }
        return result;
    }
}
