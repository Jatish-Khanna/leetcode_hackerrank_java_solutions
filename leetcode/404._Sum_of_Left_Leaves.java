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
