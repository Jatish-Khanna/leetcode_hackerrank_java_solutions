
public class Solution {
  
   static class TreeNode {
     int val;
     TreeNode left, right;
     TreeNode(int val) { this.val = val; }
   }
   
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) { return true;}
        return isUnivalTree(root, root.val);        
    }
    
    public boolean isUnivalTree(TreeNode node, int val) {
        if(node == null) { return true;}
        return node.val == val && isUnivalTree(node.left, val) && isUnivalTree(node.right, val);
    }
}
