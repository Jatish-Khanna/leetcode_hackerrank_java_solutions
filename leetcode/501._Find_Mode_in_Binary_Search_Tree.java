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
    List<Integer> list;
    int max;
    int prev = -1;
    int count;
    public int[] findMode(TreeNode root) {
        if(root == null) {return new int[]{}; }
        max = 0;
        list = new ArrayList<>();
        find(root);
        int []result = new int[list.size()];
        int index = 0;
        for(Integer item : list) {
            result[index++] = item;
        }
        return result;
    }
    
    private void find(TreeNode node) {
        if(node == null) { return; }
        find(node.left);
        if(node.val == prev) {
            count++;
        } else {
            count = 1;
            prev = node.val;
        }
        
        if(count == max) {
            list.add(node.val);
        } else if(count > max) {
            list.clear();
            list.add(node.val);
            max = count;
        }
        find(node.right);
    }
}
