

public class Solution {

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
