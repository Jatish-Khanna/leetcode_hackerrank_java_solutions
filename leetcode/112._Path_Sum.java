

public class Solution {

  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
  }
  
      public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) { return false;}
        if(root.left == null && root.right == null && root.val == sum) { return true; }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
