

public class Solution {

  static class ListNode {
    int val
    ListNode next;
    ListNode(int val) { this.val = val; }
  }

    public ListNode reverseBetween(ListNode head, int m, int n) {
     
        if(head == null || head.next == null) { return head;}
        
        int count = 1;

        ListNode current = head;
        while(current != null && count++ < m - 1) {
            current = current.next;
        }
        

        if( m == 1) {
            ListNode subHead = reverse(current, n - m + 1);
            return subHead;
        }
        ListNode subHead = reverse(current.next, n - m + 1);
        current.next = subHead;
        return head;
    }
    
    public ListNode reverse(ListNode current, int size) {
        ListNode prev = null;
        ListNode tail = current;
        ListNode next;
        
        while(current != null && size-- > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            
        }
        
        tail.next = current;
        //System.out.println(tail.val);
        
        return prev;
    }

}
