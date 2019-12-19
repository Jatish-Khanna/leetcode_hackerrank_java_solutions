
class Solution {
  static class TreeNode {
  
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    
  }
  
      public List<String> binaryTreePaths(TreeNode root) {
        
        
        ArrayList<String> list = new ArrayList<>();
        if(root == null) {return list;}
        buildPaths(root, String.valueOf(root.val), list);
        return list;
    }
    
    public void buildPaths(TreeNode node, String path, ArrayList<String> list) {
        if(node.left == null && node.right == null) {
            list.add(path);
            return;
        }
        if(node.left != null) { buildPaths(node.left, path + "->" +node.left.val, list);}
        if(node.right != null) { buildPaths(node.right, path + "->" +node.right.val, list);}
    }
    
}
