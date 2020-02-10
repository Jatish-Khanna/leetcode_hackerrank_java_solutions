

public class Solution {
  
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }
  
  // Optimized with secondary memory
  
    public int[] nextLargerNodes(ListNode head) {
        int count = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            count++;
        }
        
        int []result = new int[count];
        
        current = head;
        Stack<int[]> stack = new Stack<>();
        int index = 0;
        
        while(current != null) {
            // Pop all the values already seen which are smaller than the current node
            while(!stack.isEmpty() && current.val > stack.peek()[1]) {
                result[stack.pop()[0]] = current.val;
            }
            
            stack.push(new int[]{index, current.val});
            index++;
            current = current.next;
        }
        return result;
    }


  // Slow solution no memorization for already found result
    public int[] nextLargerNodes(ListNode head) {
        ListNode current = head;
        List<Integer> list = new ArrayList<>();
        while(current != null) {
            int maxVal = nextLarger(current.next, current.val);
            list.add(maxVal);
            current = current.next;
        }
        
        int []result = new int[list.size()];
        for(int index = 0; index < result.length; index++) {
            result[index] = list.get(index);
        }
        return result;
    }
    
    private int nextLarger(ListNode current, int val) {
        
        while(current != null) {
            if(current.val > val) { return current.val; }
            current = current.next;
        }
        return 0;
    }
}
