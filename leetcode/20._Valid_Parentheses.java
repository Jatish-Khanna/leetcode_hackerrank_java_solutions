

public class Solution {

    public boolean isValid(String s) {
        char []ar = new char[3];
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch =='(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if(stack.isEmpty()) {
                return false;  
            } else if(ch == ')') {
                if(stack.pop() != '(') return false;
            } else if(ch == '}') {
                if(stack.pop() != '{') return false;
            } else if(ch == ']') {
                if(stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
