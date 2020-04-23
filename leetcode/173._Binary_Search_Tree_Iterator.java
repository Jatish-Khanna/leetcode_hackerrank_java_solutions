/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Queue<TreeNode> list = new LinkedList();
    // static class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode(int val) {
    //         this.val = val;
    //     }
    // }
    // static ListNode head;
    // static ListNode tail;
    public BSTIterator(TreeNode root) {
        // ListNode head = new ListNode(-1);
        // tail = head;
        build(root);
        // head = head.next;
        // System.out.println(head.next.next.next.next.next.val);
    }
    
    private void build(TreeNode node) {
        if(node == null) { return; }
        build(node.left);
        // ListNode item = new ListNode(node.val);
        // tail.next = item;
        // tail = item;
        list.offer(node);
        build(node.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        // System.out.println(head);
        // System.out.println(head.next.next.next.next.val);
        // ListNode node = head;
        // head = head.next;
        return list.poll().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
