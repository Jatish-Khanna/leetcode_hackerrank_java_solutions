

public class Solution {

    public int maxDepth(Node root) {
        if(root == null) return 0;
        int maxDepth = 0;
        for(Node child : root.children)
            if(child != null) maxDepth = Math.max(maxDepth, maxDepth(child));
        return maxDepth + 1;
    }
}
