

public class Solution {

  // Stack solution with O(n) memory

    public int[] dailyTemperatures(int[] T) {
        int []result = new int[T.length];
        result[T.length - 1] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(T.length - 1);
        for(int index = T.length - 2; index >= 0; index--) {
               while(!stack.isEmpty() && T[stack.peek()] <= T[index]) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    result[index] = 0;
                } else {
                    result[index] = stack.peek() - index;
                }
                stack.push(index);
            
            //System.out.println(stack);
        }
            
        return result;
    }
}
