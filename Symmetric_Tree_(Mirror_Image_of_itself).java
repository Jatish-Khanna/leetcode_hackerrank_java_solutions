public class Solution {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private static boolean verifyMirrorTrees(Node nodeFirst, Node nodeSecond) {

		if (nodeFirst == null && nodeSecond == null)
			return true;
		else if (nodeFirst == null || nodeSecond == null)
			return false;

		// Check left subtree and right sub-tree if both are identical
		return (nodeFirst.data == nodeSecond.data && verifyMirrorTrees(nodeFirst.left, nodeSecond.right)
				&& verifyMirrorTrees(nodeFirst.right, nodeSecond.left));
	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);
		if (verifyMirrorTrees(root, root))
			System.out.println("Trees are mirror of each other");
		else
			System.out.println("Trees are not mirror images");
		
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(2);
		root2.left.left = new Node(3);
		root2.left.right = new Node(4);
		root2.right.left = new Node(4);
		root2.right.right = new Node(2);
		if (verifyMirrorTrees(root, root2))
			System.out.println("Trees are mirror of each other");
		else
			System.out.println("Trees are not not mirror images");
	}
}
