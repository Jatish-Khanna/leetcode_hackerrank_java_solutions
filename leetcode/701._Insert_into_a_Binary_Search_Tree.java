

public class Solution {

// Iterative - variable
    public TreeNode insertIntoBST(TreeNode root, int val) {
       if(root == null) { return new TreeNode(val); }
        insert(root, val);
       return root;
    }
    
    public void insert(TreeNode root, int val) {
        while(root != null) {
            if(val < root.val && root.left != null) {
               root = root.left;
           } else if(val > root.val && root.right != null) {
               root = root.right;
           } else {
                break;
            }
        }
        if(val < root.val) {
            root.left = new TreeNode(val);
        } else {
            root.right = new TreeNode(val);
        }
       return;
    }
}
