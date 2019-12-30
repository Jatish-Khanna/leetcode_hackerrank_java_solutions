

public class Solution {

  static class TreeNode { 
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    
  }
  
      public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root == null) { return list;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int count = size;
            Double avg = 0.0;
            while(size-- > 0) {
                TreeNode current = queue.poll();
                avg += current.val;
                if(current.left != null) { queue.offer(current.left); }
                if(current.right != null) { queue.offer(current.right); }
            }
            avg /= count;
            list.add(avg);
        }
        return list;
    }
}
