class Solution {
    public boolean checkValidString(String s) {
        if(s.isEmpty()) { return true; }
        int count = 0;
        int asterisk = 0;
        for(char par : s.toCharArray()) {
            if(par == '(') {
                count++;
            } else if(par == ')') {
                if(count > 0) {
                    count--;
                } else if(asterisk > 0) {
                    asterisk--;
                } else {
                    return false;
                }
            } else {
                if(count > 0) {
                    count--;
                    asterisk++;
                }
                asterisk++;
            }
        }
        return count == 0;
    }
}
