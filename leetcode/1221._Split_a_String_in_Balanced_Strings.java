

public class Solution {

public int balancedStringSplit(String s) {
        int lCount = 0;
        int rCount = 0;
        int count = 0;
        
        for(char str: s.toCharArray()) {
            if(str == 'L') {
                lCount++;
            } else {
                rCount++;
            }
            if(lCount == rCount) {
                count++;
            }
        }
        return count;
    }
}
