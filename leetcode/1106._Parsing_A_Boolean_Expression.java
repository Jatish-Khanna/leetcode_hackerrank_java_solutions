

public class Solution {

    public boolean parseBoolExpr(String expression) {
       HashSet<Character> found = new HashSet<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char current;
        char operation;
        for(char ch : expression.toCharArray()) {
            if(ch == ')') {
                while(stack.peek() != '(') {
                    found.add(stack.pop());
                }
                stack.pop(); // remove (
                operation = stack.pop(); // got the operator
                stack.push(operate(operation, found));
            } else if(ch != ',') {
                stack.push(ch);
            }
            found.clear();
        }
        return stack.pop() == 't' ? true : false;
    }
    
    private char operate(char operation, HashSet<Character> found) {
        switch(operation) {
            case '&':
                 return found.contains('f') ? 'f' : 't';
            case '|':
                return found.contains('t') ? 't' : 'f';
            case '!':
                return found.contains('t') ? 'f' : 't';
        }
        return '-';
    }
}
