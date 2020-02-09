

public class Solution {
  // Dynamic programming solution
  public int[] dailyTemperatures(int[] T) {
        int []result = new int[T.length];
        //result[T.length - 1] = 0;
        int next;
        
        for(int index = T.length - 1; index >= 0; index--) {
            next = index + 1;
            while(next < T.length) {
                if(T[index] < T[next]) {
                    result[index] = next - index;
                    break;
                } else if(result[next] == 0) {
                    break;
                } else {
                    next += result[next];
                }
            }
        }
        
        return result;
    }
  
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
