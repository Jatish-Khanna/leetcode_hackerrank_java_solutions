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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int max;
        TreeNode current;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            max = Integer.MIN_VALUE;
            while(size-- > 0) {
                current = queue.poll();
                max = Math.max(max, current.val);
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
