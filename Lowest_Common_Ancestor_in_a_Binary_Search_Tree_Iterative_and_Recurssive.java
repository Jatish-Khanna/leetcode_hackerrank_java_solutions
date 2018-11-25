class Solution {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

	}

	public static void main(String args[]) {
		Node root;
		root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = findLowestCommonAncestorInBinarySeachTree(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = findLowestCommonAncestorInBinarySeachTree(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = findLowestCommonAncestorInBinarySeachTree(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 4;
		n2 = 12;
		t = findLowestCommonAncestorInBinarySeachTreeRecurssive(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = findLowestCommonAncestorInBinarySeachTreeRecurssive(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = findLowestCommonAncestorInBinarySeachTreeRecurssive(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

	}

	/**
	 * Get the lowest common ancestor of both the node in Binary search tree
	 *  Assumption
	 *  - Both the nodes are present in tree
	 * @param node - root of the binary search tree
	 * @param firstData - first node in tree
	 * @param secondData - second node in tree
	 * @return - lowest common ancestor of nodes in tree
	 */
	private static Node findLowestCommonAncestorInBinarySeachTree(Node node, int firstData, int secondData) {
		// Return -1 if tree is empty
		Node noAncestor = new Node(-1);
		if (node == null)
			return noAncestor;
		
		// Iteration on left or right subtree
		while (node != null) {
			// Node data is smaller than nodes we are searching
			if (node.data < firstData && node.data < secondData) {
				// Iterate over right subtree
				node = node.right;
			} 
			// Node data is larger than both the node we are searching
			else if (node.data > firstData && node.data > secondData) {
				// Iterate over left subtree
				node = node.left;
			} else {
				// Ancestor is found considering - both the node are present in tree
				return node;
			}
		}
		return noAncestor;
	}
	
	/**
	 * Get the lowest common ancestor of both the node in Binary search tree - recurssive
	 *  Assumption
	 *  - Both the nodes are present in tree
	 * @param node - root of the binary search tree
	 * @param firstData - first node in tree
	 * @param secondData - second node in tree
	 * @return - lowest common ancestor of nodes in tree
	 */
	private static Node findLowestCommonAncestorInBinarySeachTreeRecurssive(Node node, int firstData, int secondData) {
		// if node is null - return -1
		if (node == null)
			return new Node(-1);

		// Node data is smaller than nodes we are searching
		if (node.data < firstData && node.data < secondData) {
			// recurse over right subtree
			return findLowestCommonAncestorInBinarySeachTreeRecurssive(node.right, firstData, secondData);
		} 
		// Node data is larger than nodes we are searching
		else if (node.data > firstData && node.data > secondData) {
			// Recurse over left subtree
			return findLowestCommonAncestorInBinarySeachTreeRecurssive(node.left, firstData, secondData);
		}
		// return node
		return node;
	}
}
