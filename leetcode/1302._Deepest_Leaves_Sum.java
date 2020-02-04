

public class Solution {

  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
      this.val = val;
    }
  }
  
    
    int max;
    int sum;
    
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) { return 0; }
        util(0, root);
        return sum;
    }
    
    public void util(int level, TreeNode root) {
        if(root == null) { return; }
        
        if(max < level) {
            sum = root.val;
            max = level;
        } else if(max == level) {
            sum += root.val;
        }
        util(level + 1, root.left);
        util(level + 1, root.right);
    }
}
  
