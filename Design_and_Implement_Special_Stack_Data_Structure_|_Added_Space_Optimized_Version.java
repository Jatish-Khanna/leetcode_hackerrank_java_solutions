import java.util.ArrayDeque;

class Solution {

	static ArrayDeque<Integer> stack = new ArrayDeque<>();
	static ArrayDeque<Integer> minStack = new ArrayDeque<>();

	private static void push(int data) {
		stack.push(data);
		if (minStack.isEmpty() || data <= minStack.peek()) {
			minStack.push(data);
		}
	}

	private static int pop() {
		if (stack.isEmpty())
			return -1;

		int data = stack.pop();
		if (data == minStack.peek()) {
			minStack.pop();
		}
		return data;
	}

	private static int getMin() {
		return minStack.isEmpty() ? -1 : minStack.peek();
	}

	/* Driver program to test SpecialStack methods */
	public static void main(String[] args) {

		push(10);
		push(20);
		push(30);
		System.out.println(getMin());
		push(5);
		System.out.println(getMin());
	}
}
