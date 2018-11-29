class Solution {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

	}

	private static int calculatedHeightOfTree(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(calculatedHeightOfTree(node.left), calculatedHeightOfTree(node.right));

	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(7);

		System.out.println("Height of tree is : " + calculatedHeightOfTree(root));
	}
}
