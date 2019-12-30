

public class Solution {
 
   static class TreeNode {
     int val;
     TreeNode left, right;
     TreeNode(int val) { this.val = val; }
     
   }
   
       public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) { return result;}
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0) {
                TreeNode current = queue.poll();
                if(flag) {
                list.add(current.val);
                } else {
                    list.add(0, current.val);
                }

                     if(current.left != null) { queue.add(current.left); }
                     if(current.right != null) { queue.add(current.right); }

                
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }
}
