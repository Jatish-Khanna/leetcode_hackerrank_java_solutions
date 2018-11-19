class Solution {

    private static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private static int maxLevel = 0;

    public static void main(String args[]) {
        // Build tree
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        // Print leftView
        leftViewOfTree(root, 1);
    }

    private static void leftViewOfTree(Node node, int level) {
        // Node is not valid return
        if(node == null)
            return;
        // Current node is first seen at level
        if(maxLevel < level) {
            System.out.println(node.data);
            maxLevel = level;
        }
        // Recurse over left and right subtree
        leftViewOfTree(node.left, level + 1);
        leftViewOfTree(node.right, level + 1);
    }
}
