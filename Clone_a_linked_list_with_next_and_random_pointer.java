import java.util.HashMap;

class LinkedList {

	Node head;

	static class Node {
		public int data;
		public Node next;
		public Node random;

		Node(int data) {
			this.data = data;
		}
	}

	LinkedList(Node node) {
		this.head = node;
	}

	// Insert new node with data at the front of list
	private void push(int data) {
		Node node = new Node(data);
		node.next = head;
		this.head = node;
	}

	private void print() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	private LinkedList cloneUsingHashMapONSpace() {
		HashMap<Node, Node> map = buildMapOfNodes();
		LinkedList clonedList = cloneListUsingMap(map);

		return clonedList;
	}

	private LinkedList cloneListUsingMap(HashMap<Node, Node> map) {
		Node current = head;
		Node clonedNode;

		while (current != null) {
			clonedNode = map.get(current);
			clonedNode.next = map.get(current.next);
			clonedNode.random = map.get(current.random);
			current = current.next;
		}

		return new LinkedList(map.get(head));
	}

	private HashMap<Node, Node> buildMapOfNodes() {
		HashMap<Node, Node> map = new HashMap<>();
		Node current = head;

		while (current != null) {
			map.put(current, getClonedNode(current));
			current = current.next;
		}

		return map;
	}

	private Node getClonedNode(Node current) {
		return new Node(current.data);
	}

	// Main method.
	public static void main(String[] args) {
		// Pushing data in the linked list.
		LinkedList list = new LinkedList(new Node(5));
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

		// Setting up random references.
		list.head.random = list.head.next.next;
		list.head.next.random = list.head.next.next.next;
		list.head.next.next.random = list.head.next.next.next.next;
		list.head.next.next.next.random = list.head.next.next.next.next.next;
		list.head.next.next.next.next.random = list.head.next;

		// Making a clone of the original linked list.
		LinkedList clone = list.cloneUsingHashMapONSpace();

		// Print the original and cloned linked list.
		System.out.println("Original linked list");
		list.print();
		System.out.println("\nCloned linked list");
		clone.print();
	}
}
