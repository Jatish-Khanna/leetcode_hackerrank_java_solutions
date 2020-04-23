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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE);        
    }
    
    private TreeNode bst(int[] ar, int max) {
        if(index == ar.length || ar[index] > max) { return null; }
        TreeNode node = new TreeNode(ar[index++]);
        // if(node.val <= max) {
        node.left = bst(ar, node.val);
        // }
        node.right = bst(ar, max);
        return node;
    }
    
}
