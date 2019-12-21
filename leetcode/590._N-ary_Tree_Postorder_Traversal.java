

public class Solution {

  static class Node {
    int val;
    List<Node> children;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, List<Node> children) {
      this.val = val;
      this.children = children;
    }
  }

/*
  Recurrsive method is faster than iterative method
 */
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;
        postOrderUtil(root);
        return list;
    }
    
    public void postOrderUtil(Node root) {
        
        for(Node node: root.children) {
            postOrderUtil(node);
        }        
        list.add(root.val);
    }
    
    // Iterative function
    public List<Integer> postorderIterative(Node root) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null) { return result;}
        stack.add(root);
        while(!stack.isEmpty()) {
            Node top = stack.pop();
            result.addFirst(top.val);
            for(Node nodes : top.children) {
                stack.push(nodes);
            }
        }

        return result;
    }
    
}
