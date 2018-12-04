import java.util.Scanner;
import java.util.PriorityQueue;

class Solution {

	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int kthLargest = in.nextInt();
		for (int index = 0; index < number; index++) {
			pushToQueue(in.nextInt(), kthLargest);
			System.out.println("Kth largest: " + minHeap.peek());
		}

		in.close();
	}

	private static void pushToQueue(int nextElementInStream, int kthLargest) {
		if (minHeap.size() < kthLargest) {
			minHeap.offer(nextElementInStream);
			return;
		} else if (minHeap.peek() < nextElementInStream) {
			minHeap.remove();
			minHeap.offer(nextElementInStream);
		}
	}
}
