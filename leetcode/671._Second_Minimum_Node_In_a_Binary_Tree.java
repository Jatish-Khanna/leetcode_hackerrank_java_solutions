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
    int secondMin = -1;
    int min;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) { return -1; }
        min = root.val;
        find(root);
        return secondMin;
    }
    
    private void find(TreeNode node) {
        if(node == null)  { return; }
        if((secondMin == -1  || node.val < secondMin) && node.val > min) {
            secondMin = node.val;
        }
        find(node.left);
        find(node.right);
    }
}
