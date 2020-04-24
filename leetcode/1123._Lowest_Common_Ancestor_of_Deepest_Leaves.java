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
    int maxDepth = 0;
    TreeNode ans;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) { return root; }
        process(root, 0);
        // System.out.println(ans.val);
        return ans;
    }
    
    private int process(TreeNode node, int level) {
        if(node == null) { return 0; }
        
        int left = process(node.left, level + 1);
        int right = process(node.right, level + 1);
        
        // Max depth node
        if(left == right && (left + level) >= maxDepth) {
            maxDepth = left + level;
            ans = node;
        } 
        
        return Math.max(left, right)  + 1;
    }
}
