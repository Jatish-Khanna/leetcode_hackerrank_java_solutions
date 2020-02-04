

public class Solution {

  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
      this.val = val;
    }
  }

    int sum;
    
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) { return 0; }
        util(false, root);
        return sum;    
    }
    
    private void util(boolean isEvenValueFather, TreeNode root) {
        if(root == null) { return; }
        
        if(isEvenValueFather) {
            if(root.left != null) {
                sum += root.left.val;
            }
            if(root.right != null) {
                sum += root.right.val;
            }
        }
        
        util((root.val & 1) == 0, root.left);
        util((root.val & 1) == 0, root.right);
    }
}
