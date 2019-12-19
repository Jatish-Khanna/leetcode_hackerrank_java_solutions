
public class Solution {

  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
  }
  public boolean isBalanced(TreeNode root) {
        if(root == null) { return true;}
        
        return isBalancedUtil(root) != Integer.MIN_VALUE;
    }
    
    public int isBalancedUtil(TreeNode node) {
        
        if(node == null) { return 0;}
        
        int leftHeight = isBalancedUtil(node.left);
        if(leftHeight == Integer.MIN_VALUE) { return leftHeight;}
        
        int rightHeight = isBalancedUtil(node.right);
        if(rightHeight == Integer.MIN_VALUE) { return rightHeight;}
        
        if(Math.abs(leftHeight - rightHeight) > 1) { return Integer.MIN_VALUE;}
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
