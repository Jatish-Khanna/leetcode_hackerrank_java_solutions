

public class Solution {


    int minDiff;
    int lastValue;
    public int minDiffInBST(TreeNode root) {
        if(root == null) { return -1;}
        minDiff = Integer.MAX_VALUE;
        lastValue = Integer.MAX_VALUE;
        inorder(root);
        return minDiff;
    }
    
    private void inorder(TreeNode node) {
        if(node == null) { return; }
        inorder(node.left);
        if(lastValue != Integer.MAX_VALUE) {
            minDiff = Math.min(minDiff, node.val - lastValue);
        } 
        lastValue = node.val;
        inorder(node.right);
    }
}
