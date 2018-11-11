class Solution {
	static Node head; // head of list
	/* Linked list Node */
static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
}

	public static void addFirst(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	static void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.println("NULL");
	}

	public static void main(String args[]) {

		// create a list 10->20->30->40->50->60
		for (int i = 60; i >= 10; i -= 10)
			addFirst(i);

		System.out.println("Given list");
		printList();

		rotate(4);
		System.out.println("Rotated Linked List");
		printList();

		rotateKSizeList(head, 4);
		System.out.println("Rotated Linked List");
		printList();

	}

	private static void rotate(int rotateAt) {
		int count = 1;
		Node current = head;
		while (count < rotateAt && current != null) {
			current = current.next;
			count++;
		}
		if (current == null || current.next == null)
			return;
		Node nextNode = current.next;
		while (nextNode.next != null)
			nextNode = nextNode.next;
		nextNode.next = head;
		head = current.next;
		current.next = null;
	}

	private static Node rotateKSizeList(Node first, int kSize) {
		Node previous = null, current = first;
		Node next = null;
		int count = 0;
		while (count < kSize && current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			count++;
		}

		if (next != null)
			first.next = rotateKSizeList(next, kSize);
		head = previous;
		return previous;
	}
}
