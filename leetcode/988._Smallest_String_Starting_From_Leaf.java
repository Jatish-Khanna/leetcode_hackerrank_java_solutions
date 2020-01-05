

public class Solution {

  static class TreeNode {
   int val;
   TreeNode left, right;
   TreeNode(int val) { this.val  = val; } 
   
 }

       String smallest = "";
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) { return smallest; }
        dfs(root, "");
        return smallest;
    }
    
    public void dfs(TreeNode node, String current) {
        
        char curr = (char)(node.val + 'a');
        String newStr = curr + current;
        if(node.left == null && node.right == null) {
            
            if(smallest.compareTo(newStr) > 0 || "".equals(smallest)) {
                smallest = newStr;
            }
        }
        if(node.left != null) { dfs(node.left, newStr); }
        if(node.right != null) { dfs(node.right, newStr); }
    }
}
