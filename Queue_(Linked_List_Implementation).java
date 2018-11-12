class Solution {

	static class Node<T> {
		T key;
		Node<T> next;

		public Node(T key) {
			this.key = key;
		}
	}

	static class Queue<T> {
		Node<T> front, rear;

		public void enqueue(T key) {
			Node<T> newNode = new Node<>(key);
			if (rear == null) {
				rear = newNode;
				front = rear;
				return;
			}
			rear.next = newNode;
			rear = newNode;
		}

		public Node<T> dequeue() {
			Node<T> storedNode = front;
			if (storedNode == null)
				return null;

			front = front.next;
			rear = front == null ? null : rear;
			return storedNode;
		}
	}

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		q.enqueue(10);
		q.enqueue(20);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

		System.out.println("Dequeued item is " + q.dequeue().key);
	}
}
