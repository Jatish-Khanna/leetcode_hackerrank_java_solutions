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
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) { return 0; }
        maxdiff(root, root.val, root.val);
        return maxDiff;
    }
    
    private void maxdiff(TreeNode node, int min, int max) {
        if(node == null) { return; }
        
        
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));
        if(min > node.val) {
            min = node.val;
        } else if(max < node.val) {
            max = node.val;
        }
        
        maxdiff(node.left, min, max);
        maxdiff(node.right, min, max);
    }
}
