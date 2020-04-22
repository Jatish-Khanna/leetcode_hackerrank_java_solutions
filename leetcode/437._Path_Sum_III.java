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
    int count = 0;
    
    public int pathSum(TreeNode root, int sum) {
        if(root == null) { return 0; }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        path(0, map, root, sum);
        
        return count;
    }
    
    private void path(int cSum, HashMap<Integer, Integer> map, TreeNode node, int sum) {
        if(node == null) { return; }
        cSum += node.val;
        if(map.containsKey(cSum - sum)) { count += map.get(cSum - sum); }
        
        map.put(cSum, map.getOrDefault(cSum, 0) + 1);
        // System.out.println(map);
        path(cSum, map, node.left, sum);
        path(cSum, map, node.right, sum);
        map.put(cSum, map.get(cSum) - 1);
    }
}
