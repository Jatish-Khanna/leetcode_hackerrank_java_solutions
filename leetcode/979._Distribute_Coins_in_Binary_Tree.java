/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count = 0;
    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return count;
    }
    
    private int postOrder(TreeNode node) {
        if(node == null) { return 0; }
        
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        
        if(node.left != null) {
            count += Math.abs(left - 1);
            node.val += left - 1;
        }
        
        if(node.right != null) {
            count += Math.abs(right - 1);
            node.val += right - 1;
        }
        return node.val;
    }
}
