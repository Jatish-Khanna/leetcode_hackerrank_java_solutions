class Solution {
    public boolean validPalindrome(String s) {
        char []ch = s.toCharArray();
        
        int start = 0;
        int end = ch.length - 1;
        
        while(start < end) {
            if(ch[start] != ch[end]) {
                // System.out.println(ch[start]+ " " + ch[end]);
                // System.out.println(start+ " " + end);
                if(ch[start + 1] == ch[end]) {
                    
                    if(validate(ch, start+1, end)) {
                        return true;
                    }
                } 
                if(ch[start] == ch[end - 1]) {    
                    return validate(ch, start, end - 1);
                } else {
                    return false;
                }
            }
            start++;
            end--;
        }
        return true;
    }
    
    private boolean validate(char []ch, int start, int end) {
        while(start < end) {
            if(ch[start] != ch[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
