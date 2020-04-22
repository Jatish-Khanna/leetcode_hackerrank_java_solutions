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
    int min = Integer.MAX_VALUE;
    public boolean findTarget(TreeNode root, int k) {
        return check(new HashSet<>(), root, k);
    }
    
    private boolean check(HashSet<Integer> seen, TreeNode node, int k) {
        if(node == null) { return false; }
        
        // First check and then add the value as seen
        if(seen.contains(k - node.val)) {
            return true;
        }
        seen.add(node.val);
        min = Math.min(min, node.val);
        
        if(check(seen, node.left, k)) {
            return true;
        }
        if(min + node.val > k ) {
            return false;
        }
        return check(seen, node.right, k);
    }
}
