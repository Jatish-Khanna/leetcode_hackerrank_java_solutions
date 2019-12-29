
public class Solution {

  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    
  }
  
  
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(root == null) { return result;}
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if(current.left != null) { queue.add(current.left); }
                if(current.right != null) { queue.add(current.right); }
            }
            result.addFirst(list);
        }
        //Collections.reverse(result);
        return result;
    }
}
