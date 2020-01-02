

public class Solution {

  static class TreeNode { 
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.va = val; } 
  }
      TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null) { return true;}
        if(!isValidBST(root.left)) { return false;}
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
       return isValidBST(root.right);
        
    }
}
