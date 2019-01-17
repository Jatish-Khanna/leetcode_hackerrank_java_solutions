import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	static HashMap<Integer, Integer> countAtSameLevel = new HashMap<>();

	private static int maxwidthUsingLevelOrderTraversal(Node node) {
		if (node == null) {
			return 0;
		}

		Queue<Node> traverseNode = new LinkedList<>();
		traverseNode.offer(node);
		int maxwidth = 0;
		int counter;
		Node currentNode;

		while (!traverseNode.isEmpty()) {

			maxwidth = Math.max(maxwidth, traverseNode.size());
			counter = traverseNode.size();
			while (counter > 0) {
				currentNode = traverseNode.remove();
				if (currentNode.left != null) {
					traverseNode.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					traverseNode.offer(currentNode.right);
				}
				counter--;
			}
		}
		return maxwidth;
	}

	private static int maxwidthUsingPreOrder(Node node) {
		int maxWidth = 0;

		if (node == null) {
			return maxWidth;
		}

		preOrderTraversal(node, 0);

		for (Map.Entry<Integer, Integer> entry : countAtSameLevel.entrySet()) {
			maxWidth = Math.max(maxWidth, entry.getValue());
		}
		return maxWidth;

	}

	private static void preOrderTraversal(Node node, int level) {
		if (node == null) {
			return;
		}

		countAtSameLevel.put(level, countAtSameLevel.getOrDefault(level, 0) + 1);
		preOrderTraversal(node.left, level + 1);
		preOrderTraversal(node.right, level + 1);

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(8);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);

		/*
		 * Constructed Binary tree is: 1 / \ 2 3 / \ \ 4 5 8 / \ 6 7
		 */

		System.out.println("Maximum width = " + maxwidthUsingLevelOrderTraversal(root));
		System.out.println("Maximum width = " + maxwidthUsingPreOrder(root));
	}
}
