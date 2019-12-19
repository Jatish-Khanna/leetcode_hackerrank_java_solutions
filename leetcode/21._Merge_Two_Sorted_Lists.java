

public class Solution {

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    
  }
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode list = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }
        
        if(l1 != null) {
            list.next = l1;
        } else if(l2 != null) {
            list.next = l2;
        }
        return dummy.next;
    }
}
