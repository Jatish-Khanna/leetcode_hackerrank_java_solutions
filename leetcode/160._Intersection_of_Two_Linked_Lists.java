

public class Solution {
  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    
  }
  
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        
        while(currentA != currentB) {
            currentA = currentA != null ? currentA.next : headB;
            currentB = currentB != null ? currentB.next : headA;
        }
        return currentA;
    }
}
