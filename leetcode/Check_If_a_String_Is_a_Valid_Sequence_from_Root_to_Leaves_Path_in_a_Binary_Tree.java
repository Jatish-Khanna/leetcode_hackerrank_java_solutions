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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(arr.length == 0 && root == null) {
            return true;
        }
        return check(0, arr, root);
    }
    private boolean check(int id, int[] arr, TreeNode node) {
        if(id >= arr.length || node == null || arr[id] != node.val) {
            return false;
        }
        if(id == arr.length - 1 && node != null) {
            if(node.val == arr[id] && node.left == null && node.right == null) {
                return true;
            } else {
                return false;
            }
        } 
        return check(id + 1, arr, node.left) || check(id + 1, arr, node.right);
        
    }
}
