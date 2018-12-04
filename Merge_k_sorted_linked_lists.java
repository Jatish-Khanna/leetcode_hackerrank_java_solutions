import java.util.Comprator;
import java.util.PriorityQueue;

class Solution {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

// Driver program to test above 
	public static void main(String[] args) {
		int k = 3; // Number of linked lists

		// an array of pointers storing the head nodes
		// of the linked lists
		Node arr[] = new Node[k];

		// creating k = 3 sorted lists
		arr[0] = new Node(1);
		arr[0].next = new Node(3);
		arr[0].next.next = new Node(5);
		arr[0].next.next.next = new Node(7);

		arr[1] = new Node(2);
		arr[1].next = new Node(4);
		arr[1].next.next = new Node(6);
		arr[1].next.next.next = new Node(8);

		arr[2] = new Node(0);
		arr[2].next = new Node(9);
		arr[2].next.next = new Node(10);
		arr[2].next.next.next = new Node(11);

		// merge the k sorted lists
		Node head = mergeKSortedLists(arr, k);

		// print the merged list
		printList(head);

	}

	private static Node mergeKSortedLists(Node[] arr, int numberOfList) {
		PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return n1.data - n2.data;
			}

		});
		Node head = null, last = null;

		for (int index = 0; index < numberOfList; index++) {
			minHeap.offer(arr[index]);
		}

		if (minHeap.size() > 1) {
			head = minHeap.poll();
			last = head;
		}

		while (!minHeap.isEmpty()) {
			if (last.next != null) {
				minHeap.offer(last.next);
			}
			Node current = minHeap.poll();
			last.next = current;
			last = current;
		}

		return head;
	}

	private static void printList(Node node) {

		if (node == null)
			return;
		Node current = node;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
}
