

public class Solution {
    
    // Faster solution in terms of CPU cycles, dealing with the indexes
     public String generateTheString(int n) {
        //StringBuilder sb = new StringBuilder();
        char []ar = new char[n];
        
        while(n > 1) {
            ar[--n] = 'a';
        }
        if(ar.length % 2 == 0) {
            ar[--n] = 'b';
        } else {
            ar[--n] = 'a';
        }
        return new String(ar);
    }
    
    // Slower solution in terms of CPU cycles

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
