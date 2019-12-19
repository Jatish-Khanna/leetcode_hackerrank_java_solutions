

public class Solution {

public String removeDuplicates(String S) {
     Stack<Character> stack = new Stack<>();
        
        for(char ch : S.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(ch);
         
                continue;
            }
            if(stack.peek() == ch) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        StringBuilder build = new StringBuilder();
        for(char ch : stack) {
            build.append(ch);
        }
        return build.toString();
    }
}
