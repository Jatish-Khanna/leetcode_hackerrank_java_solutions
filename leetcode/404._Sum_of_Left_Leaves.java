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
    
    // with state management

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) { return 0; }
        return sum(root);
        // return sum;
    }
    
    private int sum(TreeNode node) {
        if(node == null) { return 0; }
        
        int left = sum(node.left);
        int right = sum(node.right);
        
         if(node.left != null) {
            if(node.left.left == null && node.left.right == null) {
                return node.left.val + left + right;
            }
        }
        
        return left + right;
    }

    
    // Without state management
    
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) { return 0; }
        sum(root);
        return sum;
    }
    
    private void sum(TreeNode node) {
        if(node == null) { return; }
        if(node.left != null) {
            if(node.left.left == null && node.left.right == null) {
                sum+= node.left.val;
            }
            sum(node.left);
        }
        sum(node.right);
    }
}
