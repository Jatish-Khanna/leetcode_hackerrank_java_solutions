import java.util.ArrayDeque;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int queries = in.nextInt();
		int type = 0;
		int value;
		ArrayDeque<Integer> supportDeque = new ArrayDeque<>();
		ArrayDeque<Integer> supportEnque = new ArrayDeque<>();

		for (int query = 0; query < queries; query++) {
			type = in.nextInt();
			switch (type) {
			case 1:
				value = in.nextInt();
				supportEnque.push(value);
				break;
			case 2:
				performDequeOperation(supportDeque, supportEnque);
				break;
			case 3:
				printStackPointer(supportDeque, supportEnque);
				break;

			}
		}
		in.close();
	}

	private static void printStackPointer(ArrayDeque<Integer> supportDeque, ArrayDeque<Integer> supportEnque) {
		transferData(supportDeque, supportEnque);
		System.out.println(supportDeque.peek());
	}

	private static void performDequeOperation(ArrayDeque<Integer> supportDeque, ArrayDeque<Integer> supportEnque) {
		transferData(supportDeque, supportEnque);
		supportDeque.pop();
	}

	private static void transferData(ArrayDeque<Integer> supportDeque, ArrayDeque<Integer> supportEnque) {
		if (!supportDeque.isEmpty()) {
			return;
		}
		while (!supportEnque.isEmpty()) {
			supportDeque.push(supportEnque.pop());
		}
		if (supportDeque.isEmpty()) {
			throw new NullPointerException();
		}

	}

}
