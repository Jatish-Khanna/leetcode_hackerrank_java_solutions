
public class Solution {

  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode current = head;
        ListNode prev = null;
        ListNode nextI = null;

        if(!hasKNodes(head, k)) {
            return head;
        }
        
        while(current != null && count  < k) {
            nextI = current.next;
            current.next = prev;
            prev = current;
            current = nextI;
            count++;
            
        }
        if(nextI != null) {
            head.next = reverseKGroup(nextI, k);
        }
        return  prev;
    }
    
    private boolean hasKNodes(ListNode head, int k) {
        int count = 0;
        while(count < k && head != null){
            head = head.next;
            count++;
        }
        return count == k;
    }
}
