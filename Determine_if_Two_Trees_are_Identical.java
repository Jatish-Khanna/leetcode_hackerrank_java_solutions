public class Solution {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private static boolean verifyIdenticalTrees(Node nodeFirst, Node nodeSecond) {

		if (nodeFirst == null && nodeSecond == null)
			return true;
		else if (nodeFirst == null || nodeSecond == null)
			return false;

		// Check left and right sub-tree if both are identical
		return (nodeFirst.data == nodeSecond.data && verifyIdenticalTrees(nodeFirst.left, nodeSecond.left)
				&& verifyIdenticalTrees(nodeFirst.right, nodeSecond.right));
	}

	/* Driver program to test identicalTrees() function */
	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);

		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);

		if (verifyIdenticalTrees(root1, root2))
			System.out.println("Both trees are identical");
		else
			System.out.println("Trees are not identical");

		Node root3 = new Node(1);
		root3.left = new Node(2);
		root3.right = new Node(3);
		root3.left.left = new Node(4);
		root3.left.right = new Node(3);

		if (verifyIdenticalTrees(root1, root3))
			;

		if (verifyIdenticalTrees(root1, root3))
			System.out.println("Both trees are identical");
		else
			System.out.println("Trees are not identical");

	}
}
