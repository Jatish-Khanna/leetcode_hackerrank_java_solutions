

public class Solution {

  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    
  }
  
  static class Pair {
  TreeNode parent, child;
        Pair(TreeNode parent, TreeNode child) {
            this.parent = parent;
            this.child = child;
        }
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(null, root));
        TreeNode xParent = null;
        TreeNode yParent = null;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Pair current = queue.poll();
                if(current.child.val == x) {
                    xParent = current.parent;
                } else if(current.child.val == y) {
                    yParent = current.parent;
                }
                
                if(current.child.left != null) {
                    queue.offer(new Pair(current.child, current.child.left));
                }
                if(current.child.right != null) {
                    queue.offer(new Pair(current.child, current.child.right));
                }
            }
            
            if(xParent != null && yParent != null && xParent != yParent) {
                return true;
            } else if(xParent != null || yParent != null) {
                return false;
            }
        }
        return false;
    }
}
