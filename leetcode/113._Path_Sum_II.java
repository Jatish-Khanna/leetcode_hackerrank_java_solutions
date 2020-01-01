

public class Solution {

  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
  }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
       List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        pathSumUtil(root, sum, list, result);
        return result;
    }
    
    public void pathSumUtil(TreeNode node, int sum, ArrayList<Integer> list, List<List<Integer>> result) {
        if(node.left == null && node.right == null && node.val == sum) {
            list.add(node.val);
            result.add((ArrayList<Integer>)list.clone());
            list.remove(list.size() - 1);
        }
        list.add(node.val);
        if(node.left != null) {
            pathSumUtil(node.left, sum - node.val, list, result);
        }
        
        if(node.right != null) {
            pathSumUtil(node.right, sum - node.val, list, result);
        }
        list.remove(list.size() - 1);
    }
}
