

public class Solution {
  
   static class ListNode {
     int val;
     ListNode next;
     ListNode(int val) { this.val = val; }
   }
      public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next;
        ListNode current = head;
        
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
