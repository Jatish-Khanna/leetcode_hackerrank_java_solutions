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
    int max;
    int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        max = -1;
        find(root, 0);
        return value;
    }
    
    private void find(TreeNode node, int level) {
        if(node == null) { return; }
        if(max < level) {
            max = level;
            value = node.val;
        }
        find(node.left, level + 1);
        find(node.right, level + 1);
    }
}
