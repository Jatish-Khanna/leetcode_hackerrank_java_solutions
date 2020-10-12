

public class Solution {

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    
  }
  
  // simple
  public ListNode removeElements(ListNode head, int val) {
        
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode removed = dummy;
        ListNode current = head;
        while(current != null) {
            if(current.val != val) {
                removed.next = current;
                removed = removed.next;
            }
            current = current.next;
        }
        // Fix for the last element;
        removed.next = null;
        return dummy.next;
    }
  
  
  // Lot of code caos
    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null) {
            return null;
        }
        ListNode prev;
        ListNode current = head;
        while(current != null && current.val == val) {
            current = current.next;
        }
        head = current;
        prev = current;
        while(current != null) {
            if(current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
