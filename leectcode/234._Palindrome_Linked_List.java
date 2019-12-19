
public class Solution {

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
  }
  
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHalf = reverse(slow.next);
        ListNode secondHead = reverseHalf;
        ListNode firstHead = head;
        System.out.println(secondHead.val);
        while(firstHead != null && secondHead != null) {
            if(firstHead.val != secondHead.val) {
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
        
    }
    
    public ListNode reverse(ListNode node) {
        ListNode prev = null, next;
        ListNode current = node;
        
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}  
