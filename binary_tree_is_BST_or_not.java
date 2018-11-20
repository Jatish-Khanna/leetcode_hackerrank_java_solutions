class Solution {

	static class Node {
		int data;
		public Node left;
		public Node right;

		public Node(int data) {
			super();
			this.data = data;
		}
	}

	public static void main(String args[]) {
		Node root;
		root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(6);

		if (checkBinarySearchTree(root))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}

	private static boolean checkBinarySearchTree(Node node) {
		if (node == null)
			return true;
		return checkBinarySearchTree(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBinarySearchTree(Node node, int minValue, int maxValue) {
		if (node == null)
			return true;
		if (node.data < minValue || node.data > maxValue)
			return false;
		return checkBinarySearchTree(node.left, minValue, node.data) &&
		checkBinarySearchTree(node.right, node.data, maxValue);
	}
}
