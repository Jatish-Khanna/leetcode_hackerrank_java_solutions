

public class Solution {
  
   static class TreeNode {
     int val;
     TreeNode left, right;
     TreeNode(int val) { this.val = val; }
     
   }
   
    int min = 0;
    public int minDepth(TreeNode root) {
        if(root == null) { return 0; }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while(size-- > 0) {
                TreeNode current = queue.poll();
                if(current.left == null && current.right == null) {
                    return depth;
                }
                if(current.left != null) { queue.offer(current.left); }
                if(current.right != null) { queue.offer(current.right); }
            }
        }
        
        return depth;
    }
}
