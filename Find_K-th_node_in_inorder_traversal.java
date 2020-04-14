

public TreeNode getNode(TreeNode root, int k) {
  if(root == null) return null; 
  int left = root.left == null ? 0 : root.left.descendents;
  if(left >= k) 
    return getNode(root.left, k);
  else if(left + 1 == k) 
    return root;
  else 
    return getNode(node.right, k-left-1);
}
