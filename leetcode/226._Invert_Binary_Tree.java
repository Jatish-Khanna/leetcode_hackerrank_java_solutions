

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) { return root; }
        return invertTreeUtil(root);
        //return root;
    }
    
    private TreeNode invertTreeUtil(TreeNode node) {
        if(node == null) { return node; }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        invertTreeUtil(node.left);
        invertTreeUtil(node.right);
        return node;
    }
}
