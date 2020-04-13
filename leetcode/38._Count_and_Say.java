

public class Solution {


    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        
        String prev = countAndSay(n - 1);
        
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int index = 1;
        for(; index < prev.length(); index++) {
            if(prev.charAt(index - 1) == prev.charAt(index)) {
                ++count;
            } else {
                sb.append(count).append(prev.charAt(index - 1));
                count = 1;
            }
        }
        sb.append(count).append(prev.charAt(index - 1));
        return sb.toString();
    }
}
