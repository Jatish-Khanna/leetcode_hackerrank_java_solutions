

public class Solution {

  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {this.val = val; }
    
  }
  
  
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) { return root;}
        
        if(root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
        
    }
}
