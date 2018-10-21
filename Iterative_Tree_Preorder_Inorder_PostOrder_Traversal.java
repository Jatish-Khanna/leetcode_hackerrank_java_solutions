import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Node {
  Node left;
  Node right;
  int data;
  Node(int data){
    this.data = data;
    left = null;
    right = null;
  }
}

class Solution {
    /*
     * you only have to complete the function given below. Node is defined as
     *
     * class Node { int data; Node left; Node right; }
     *
     */
 
    public static void preOrder(Node root) {
        Deque<Node> visited = new ArrayDeque<>();
        Node current;
        visited.push(root);

        while (!visited.isEmpty()) {
            current = visited.pop();
            System.out.print(current.data + " ");

            if (current.right != null)
                visited.push(current.right);
            if (current.left != null)
                visited.push(current.left);
        }
    }
  
      public static void postOrder(Node root) {
        Deque<Node> visited = new ArrayDeque<>();
        Node current = root;
        do {
            while (current != null) {
                visited.push(current);
                visited.push(current);
                current = current.left;
            }

            if (visited.isEmpty()) return;
            current = visited.pop();
            if ((!visited.isEmpty()) && current == visited.peek()) {
                current = current.right;
            } else {
                System.out.print(current.data + " ");
                current = null;
            }
        } while (!visited.isEmpty());
    }
    
    public static void inOrder(Node root) {
        Deque<Node> visited = new ArrayDeque<>();
        Node current = root;
        if (current == null)
            return;
        do {
            while (current != null) {
                visited.push(current);
                current = current.left;
            }

            current = visited.pop();
            System.out.print(current.data + " ");
            current = current.right;

        } while ((!visited.isEmpty()) || current != null);
    }
    
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        inOrder(root);
    }
}
