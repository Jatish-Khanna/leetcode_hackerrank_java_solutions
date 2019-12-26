

public class Solution {


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) { return head;}
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        
        while(current != null) {
            int val = current.val;
            ListNode tmp = current;
            int count = 0;
            while(tmp != null && tmp.val == val) {
                count++;
                tmp = tmp.next;
            }

            if(count > 1) {
                prev.next = tmp;
                current = tmp;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return dummy.next;
    }
}
