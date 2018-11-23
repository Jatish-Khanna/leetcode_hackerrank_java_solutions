import java.util.ArrayDeque;

class Solution {
	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static Node root;

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		System.out.println("Spiral Order traversal of Binary Tree is ");
		printSpiralOfBinaryTree(root);
	}

	static void printSpiralOfBinaryTree(Node node) {
		ArrayDeque<Node> rightLeftStack = new ArrayDeque<>();
		ArrayDeque<Node> leftRightStack = new ArrayDeque<>();

		leftRightStack.push(node);

		while (!rightLeftStack.isEmpty() || !leftRightStack.isEmpty()) {
			while (!leftRightStack.isEmpty()) {
				Node processNode = leftRightStack.pop();
				printData(processNode);
				if (processNode.right != null)
					rightLeftStack.push(processNode.right);
				if (processNode.left != null)
					rightLeftStack.push(processNode.left);
			}

			while (!rightLeftStack.isEmpty()) {

				Node processNode = rightLeftStack.pop();
				printData(processNode);
				if (processNode.left != null)
					leftRightStack.push(processNode.left);
				if (processNode.right != null)
					leftRightStack.push(processNode.right);
			}

		}

	}

	static void printData(Node node) {
		System.out.print(node.data + " ");
	}
}
