class Solution {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	static int maxCalculatedDiameter = Integer.MIN_VALUE;

	static int calculateDiameterOfTree(Node node) {

		if (node == null)
			return 0;

		int leftDiameter = calculateDiameterOfTree(node.left);
		int rightDiameter = calculateDiameterOfTree(node.right);

		int calculatedDiameter = leftDiameter + rightDiameter + 1;

		maxCalculatedDiameter = Math.max(maxCalculatedDiameter, calculatedDiameter);

		return Math.max(leftDiameter, rightDiameter) + 1;

	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(8);
		root.left.right.right.right = new Node(9);
		calculateDiameterOfTree(root);
		System.out.println("The diameter of given binary tree is : " + maxCalculatedDiameter);
	}
}
