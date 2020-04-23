/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    HashSet<Integer> values;
    
    // Same speed
        HashSet<Integer> values;
    public FindElements(TreeNode root) {
        values = new HashSet<>();
        rebuild(root, 0);
        
    }
    
    private void rebuild(TreeNode node, int value) {
        if(node == null) { return; }
        node.val = value;
        values.add(value);
        rebuild(node.left, (value << 1) + 1);
        rebuild(node.right, (value << 1) + 2);
        
    }
    
    // Same speed
    public FindElements(TreeNode root) {
        root.val = 0;
        values = new HashSet<>();
        values.add(0);
        rebuild(root);
        
    }
    
    private void rebuild(TreeNode node) {
        if(node == null) { return; }
        values.add(node.val);
        if(node.left != null) {
            node.left.val = 2* node.val + 1;
            rebuild(node.left);
        }
        if(node.right != null) {
            node.right.val = 2* node.val + 2;
            rebuild(node.right);
        }
        
        
        
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
