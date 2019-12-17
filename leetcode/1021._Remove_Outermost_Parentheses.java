
public class Solution {

public String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(char parentheses : S.toCharArray()) {
            if(parentheses == '(') {
                count++;
            } 
            if(count > 1) {
                sb.append(parentheses);
            }
            if(parentheses == ')') {
                count--;
            }
        }
        return sb.toString();
    }
}
