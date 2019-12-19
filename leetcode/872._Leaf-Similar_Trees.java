

public class Solution {

  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val;}
   }
   public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2,l2);
        return l1.equals(l2);
    }
    
    public void dfs(TreeNode node, ArrayList<Integer> list) {
        
        if(node == null) {
            return;
        }
        
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
