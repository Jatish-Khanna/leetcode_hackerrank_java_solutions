import java.util.LinkedList;
import java.util.Queue;

class Solution {

	static class Node {
		int data;
		Node leftChild;
		Node rightChild;
		Node sameLevelRight;

		Node(int data) {
			super();
			this.data = data;
		}
	}

	public static void main(String[] args) {

		Node root = new Node(10);
		root.leftChild = new Node(8);
		root.rightChild = new Node(2);
		root.leftChild.leftChild = new Node(3);
		root.rightChild.rightChild = new Node(90);

		levelOrderConnect(root);
    leftViewOfTree(root, 1);

	}

	static void levelOrderConnect(Node node) {
		// Stores the nodes of each level,
		Queue<Node> queue = new LinkedList<>();

		// Add root node
		queue.add(node);
		// mark the current level is finished
		queue.add(null);
		// Iterate over each node until queue is empty
		while (!queue.isEmpty()) {
			// Remove node from queue front 
			Node toProcess = queue.remove();
			// If not the end of current level i.e. node != null
			if (toProcess != null) {
				// Update the next right to current as queue front
				toProcess.sameLevelRight = queue.peek();
				// Add left child
				if (toProcess.leftChild != null)
					queue.add(toProcess.leftChild);
				// Add right child if present
				if (toProcess.rightChild != null)
					queue.add(toProcess.rightChild);

			} 
			// if queue is not empty but current node == null
			else if (!queue.isEmpty()) {
				// Add the mark that current level has been processed
				queue.add(null);
			}
		}
	}
  
  	private static void leftViewOfTree(Node node, int level) {
		// Node is not valid return
		if (node == null)
			return;
		// Current node is first seen at level
		if (maxLevel < level) {
			printNodesAtLevel(node);
			maxLevel = level;
		}
		// Recurse over left and right subtree
		leftViewOfTree(node.leftChild, level + 1);
		leftViewOfTree(node.rightChild, level + 1);
	}

	private static void printNodesAtLevel(Node node) {
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.sameLevelRight;
		}
		System.out.println("NULL");
	}
}
