

public class Solution {


    public int minAddToMakeValid(String S) {
        int open = 0;
        int close = 0;
       for(char ch : S.toCharArray()) {
           if(ch == '(') {
               open++;
           } else {
               if(open > 0) {
                 open--;
               } else {
                   close++;
               }
           }
       }
        
        return open + close;
    }
}
