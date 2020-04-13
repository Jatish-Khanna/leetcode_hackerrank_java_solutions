

public class Solution {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  
  }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root)[0] - 1;
    }
    
    public int[] dfs(TreeNode node) {
        if(node == null) {
            return new int[]{0, 0};
        }
        
        int[] left = dfs(node.left);
        int []right = dfs(node.right);
        
        int diameter = Math.max(Math.max(left[0], right[0]), left[1] + right[1] + 1);
        return new int[]{diameter, Math.max(left[1], right[1]) + 1};
    }
}
