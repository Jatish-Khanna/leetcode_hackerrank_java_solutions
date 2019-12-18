

public class Solution {
  static class ListNode {
  
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public int getDecimalValue(ListNode head) {
      ListNode current = head;
        int number = 0;
        while(current != null) {
            number = (number << 1) + current.val;
            current = current.next;
        }
        return number;
    }
}
