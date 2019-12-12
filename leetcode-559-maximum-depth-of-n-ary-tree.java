
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

    public int maxDepth(Node root) {
         if(root == null) return 0;
        int maxDepth = 0;
        for(Node child : root.children)
            if(child != null) maxDepth = Math.max(maxDepth, maxDepth(child));
        return maxDepth + 1;
}

 public int maxDepthBFS(Node root) {
        int count = 0;
        if(root == null) {
            return count;
        }
      Queue<Node> nodesAtLevel = new LinkedList<>();
      nodesAtLevel.offer(root);
      int size;
      Node current;
      //nodesAtLevel.offer(MARKER);
      while(!nodesAtLevel.isEmpty()) {
          count++;
          size = nodesAtLevel.size();
          while(size-- > 0) {
             current = nodesAtLevel.poll();
             for(Node node : current.children) {
               nodesAtLevel.offer(node);
             }
          }
      
      }
    return count;
}
}

