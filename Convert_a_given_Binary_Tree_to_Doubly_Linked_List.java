class Solution {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
	// Head of the double linked list
	static Node head;
	// previous node from the double linked list
	private static Node previousNode;

	/**
	 * Append visited node to the double linked list - last
	 * @param appendNode node to be appended
	 */
	private static void appendNodeToDoubleLinkedList(Node appendNode) {

		// Node should be non-null
		if (appendNode == null)
			return;
		// If first node - update head pointer
		if (previousNode == null) {
			head = appendNode;
		} 
		// Append to already created list
		else {
			// Left of last node - point it to current node
			previousNode.right = appendNode;
			// Double link i.e. right of current node to last seen node
			appendNode.left = previousNode;
		}
		// last visited node as current node
		previousNode = appendNode;
	}

	/**
	 * Build a Double linked list give root of tree
	 * @param node pointing to root of tree 
	 */
	private static void convertBinaryTree2DoubleLinkedList(Node node) {

		// Node is null - return
		if (node == null)
			return;
		// Inorder traversal - over left node
		convertBinaryTree2DoubleLinkedList(node.left);
		// visit the node and append to double linked list
		appendNodeToDoubleLinkedList(node);
		// In order traversal - over right node
		convertBinaryTree2DoubleLinkedList(node.right);
	}

	/**
	 * Print the converted linked list
	 */
	private static void printList() {
		// Reference to head 
		Node current = head;
		// Iterate over all the nodes
		while (current != null) {
			// Print the data
			System.out.print(current.data + " ");
			// Update processing node as next right
			current = current.right;
		}
	}

	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);

		// convert to DLL
		convertBinaryTree2DoubleLinkedList(root);

		// Print the Double linked List
		printList();
	}
}
