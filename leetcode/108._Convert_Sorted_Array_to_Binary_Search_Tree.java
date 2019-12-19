public class Solution {

  public static TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    
   }
   public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) { return null;}
        
        return createBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode createBST(int []nums, int start, int end) {
        if(start > end) { return null; }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, start, mid - 1);
        root.right = createBST(nums, mid + 1, end);
        return root;
    }
}
