/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public String tree2str(TreeNode t) {
        if(t == null) {
            return  "";
        }
        StringBuilder sb = new StringBuilder();
        build(t, sb);
        return sb.toString();
    }
    
    public void build(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if(node.left != null) {
            sb.append("(");
            build(node.left, sb);
            sb.append(")");
        } else if(node.right != null) {
            sb.append("()");
        }
        
        
        if(node.right != null){
            sb.append("(");
            build(node.right, sb);
            sb.append(")");
        }
        
    }
}
