class Solution {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

	}

	// Stores the maximum sum calculated 
	static int maxCalculatedSum = Integer.MIN_VALUE;

	/**
	 * Calculate the maximum sum between two leaves
	 * @param node root of the tree
	 * @return total sum at the root level
	 */
	private static int calculateMaxSumPathBoundedByLeafNode(Node node) {
		// For null node - sum = 0
		if (node == null)
			return 0;
		// Recursively calculate the sum of left sub tree 
		int leftSum = calculateMaxSumPathBoundedByLeafNode(node.left);
		// Recursively calculate the sum of right subtree
		int rightSum = calculateMaxSumPathBoundedByLeafNode(node.right);

		// Current calculated sum (inclusive left, right and node data)
		int currentCalculatedSum = leftSum + rightSum + node.data;
		// Update the maximum sum if greater than current maximum
		maxCalculatedSum = Math.max(maxCalculatedSum, currentCalculatedSum);

		// return the maximum sum calculated at current processed node
		return Math.max(leftSum, rightSum) + node.data;

	}

	// Driver program to test above functions
	public static void main(String args[]) {
		Node root = new Node(-15);
		root.left = new Node(5);
		root.right = new Node(6);
		root.left.left = new Node(-8);
		root.left.right = new Node(1);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(6);
		root.right.left = new Node(3);
		root.right.right = new Node(9);
		root.right.right.right = new Node(0);
		root.right.right.right.left = new Node(4);
		root.right.right.right.right = new Node(-1);
		root.right.right.right.right.left = new Node(10);
		calculateMaxSumPathBoundedByLeafNode(root);
		System.out.println("Max pathSum of the given binary tree is " + maxCalculatedSum);
	}
}
