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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) { return new LinkedList<>(); }
        Set<Integer> values = new HashSet<>();
        List<TreeNode> list = new LinkedList<>();
        for(int element : to_delete) {
            values.add(element);    
        }
        
        delete(root, list, values);
        if(!values.contains(root.val)) {
            list.add(root);
        }
        return list;
    }
    
    private TreeNode delete(TreeNode node, List<TreeNode> list, Set<Integer> values) {
        if(node == null) { return node; }
        
        node.left = delete(node.left, list, values);
        node.right = delete(node.right, list, values);
        if(values.contains(node.val)) {
            if(node.left !=  null) {
                list.add(node.left);
            }
            if(node.right != null) {
                list.add(node.right);
            }
            return null;
        }
        return node;
    }
}
