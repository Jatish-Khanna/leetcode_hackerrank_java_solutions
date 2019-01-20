class Solution {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node head;
	static final String NULL_POINT = "NULL";

	// Push at the front of list
	private static void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	private static void printList() {

		Node node = head;
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println(NULL_POINT);
	}

	private static void swapKthNode(int kthNode) {
		if (kthNode == 0)
			return;
		int countNodes = countNumberOfNodesInList();
		// Number of nodes are not present
		if (countNodes < kthNode) {
			return;
		}

		// True for Odd number of nodes, middle node or single node
		if ((kthNode << 1) - 1 == countNodes) {
			return;
		}

		Node kthNodeFromLeft = head;
		Node previousOfKthLeft = null;
		int count = 1;
		while (count < kthNode) {
			previousOfKthLeft = kthNodeFromLeft;
			kthNodeFromLeft = kthNodeFromLeft.next;
			count++;
		}

		Node kthNodeFromRight = head;
		Node previousOfKthRight = null;

		while (count < countNodes) {
			previousOfKthRight = kthNodeFromRight;
			kthNodeFromRight = kthNodeFromRight.next;
			count++;
		}

		if (previousOfKthLeft != null) {
			previousOfKthLeft.next = kthNodeFromRight;
		}

		if (previousOfKthRight != null) {
			previousOfKthRight.next = kthNodeFromLeft;
		}

		Node toSwap = kthNodeFromLeft.next;
		kthNodeFromLeft.next = kthNodeFromRight.next;
		kthNodeFromRight.next = toSwap;

		if (kthNode == 1) {
			head = kthNodeFromRight;
		} else if (kthNode == countNodes) {
			head = kthNodeFromLeft;
		}

		System.out.println();
	}

	private static int countNumberOfNodesInList() {
		Node node = head;
		int count = 0;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}

	// Driver code to test above
	public static void main(String[] args) {

		for (int i = 8; i >= 1; i--) {
			push(i);
		}

		System.out.print("Original linked list: ");
		printList();
		System.out.println("");

		for (int i = 1; i < 9; i++) {
			swapKthNode(i);
			System.out.println("Modified List for k = " + i);
			printList();
			System.out.println("");
		}
	}
