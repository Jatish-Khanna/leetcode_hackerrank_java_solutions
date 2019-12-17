

public class Solution {

  staic class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    TreeNode head;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        head = dummy;
        inOrder(root);
        return dummy.right;
    }
    
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        root.left = null;
        head.right = root;
        head = root;
        inOrder(root.right);
    }
    
}
