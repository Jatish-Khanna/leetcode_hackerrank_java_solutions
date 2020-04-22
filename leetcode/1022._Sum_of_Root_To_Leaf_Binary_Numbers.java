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
    
    // static int total = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) { return 0; }
        
        return sum(0, root);
        
        // return total;
    }
    
    private int sum(int pathSum, TreeNode node) {
        if(node == null) {
            return 0;
        }
        pathSum = pathSum * 2 + node.val;
        
        if(node.left == null && node.right == null) {
            return pathSum;
        }
        return sum(pathSum, node.left) + sum(pathSum, node.right);
    }
}
