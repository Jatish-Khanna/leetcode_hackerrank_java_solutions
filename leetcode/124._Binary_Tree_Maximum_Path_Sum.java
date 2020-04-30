/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // if(root == null) {
        //     return 0;
        // }
        calculate(root);
        return max;
    }
    
    private int calculate(TreeNode node) {
        if(node == null) { return 0; }
        
        int left = calculate(node.left);
        int right = calculate(node.right);
        int ret = node.val;
        if(left >= 0 && right >= 0) {
            max = Math.max(max, node.val + left + right);
            ret = node.val + Math.max(left, right);
        } else if(right >= 0) {
            ret = node.val + right;
        } else if(left >= 0) {
            ret = node.val + left;
        } else {
            ret = node.val;
        }
        max = Math.max(max, ret);
        return ret;
    }
} 
