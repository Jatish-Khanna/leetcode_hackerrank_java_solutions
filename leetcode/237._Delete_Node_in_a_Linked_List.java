

public class Solution {

  static class ListNode {
     int val;
     ListNode next;
     ListNode(int val) { this.val = val; }
   }
   
    public void deleteNode(ListNode node) {
        while(node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        // Delete node
        node.val = node.next.val;
        node.next = null;
    }
}
