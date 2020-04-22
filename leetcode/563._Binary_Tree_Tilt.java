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
    int total = 0;
    public int findTilt(TreeNode root) {
        if(root == null) { return 0; }
        
        tilt(root);
        return total;
    }
    
    private int tilt(TreeNode node) {
        if(node == null) { return 0; }
        
        int left = tilt(node.left);
        int right = tilt(node.right);
        total += Math.abs(left - right);
        return left + right + node.val;
    }
}
