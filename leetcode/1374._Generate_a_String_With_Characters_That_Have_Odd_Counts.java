

public class Solution {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 1) {
            sb.append("a");
            --n;
        }
        if(sb.length() % 2 != 0) {
            sb.append("b");
        } else {
            sb.append("a");
        }
        return sb.toString();
    }
}
