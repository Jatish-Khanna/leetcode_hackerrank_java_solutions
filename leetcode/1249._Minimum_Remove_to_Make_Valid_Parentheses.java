

public class Solution {

    public String minRemoveToMakeValid(String s) {
        char []arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] == '(') {
                stack.push(index);
            } else if(arr[index] == ')') {
                if(stack.isEmpty()) {
                    arr[index] = ' ';
                } else {
                    stack.pop();
                }
            }
        }
        
        for(int index : stack) { arr[index] = ' '; }
        StringBuilder sb = new StringBuilder();
        for(char ch : arr) {
            if(ch != ' ') { sb.append(ch); }
        }
        return sb.toString();
        
    }
}
