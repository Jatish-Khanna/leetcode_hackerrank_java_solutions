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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) { return root; }
        if(p.val < q.val) {
           return lca(root, p, q);
        } else {
            return lca(root, q, p);
        }
    }
    
    private TreeNode lca(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) { return node; }
        
        if(p.val <= node.val && q.val >= node.val) {
            return node;
        }
        // TreeNode left = 
        if(q.val < node.val) {
            return lca(node.left, p, q);
        }
        return lca(node.right, p, q); 
    }
}
