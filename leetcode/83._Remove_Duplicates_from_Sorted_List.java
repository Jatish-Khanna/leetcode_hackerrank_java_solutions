

public class Solution {

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    
  }
  
  
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode current = prev.next;
        while(current != null) {
            if(prev.val == current.val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
