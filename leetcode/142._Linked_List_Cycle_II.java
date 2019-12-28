
public class Solution {

  static class ListNode {
  
    int val;
    ListNode left, right;
    ListNode(int val) { this.val = val; }
  }
  
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) { return null;}
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) { break;}
        }
        if(fast == null || fast.next == null) { return null;}
        
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
