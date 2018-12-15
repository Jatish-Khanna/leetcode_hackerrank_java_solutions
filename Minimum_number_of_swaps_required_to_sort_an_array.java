import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {


	static class DataPosition {
		private int data;
		private int position;

		DataPosition(int data, int position) {
			this.data = data;
			this.position = position;
		}

		public int getPosition() {
			return this.position;
		}

		public int getData() {
			return this.data;
		}
	}

	private static int minSwaps(int[] arr) {
		if (arr == null)
			return 0;

		ArrayList<DataPosition> list = new ArrayList<>();
		boolean[] visited = new boolean[arr.length];

		for (int index = 0; index < arr.length; index++) {
			list.add(new DataPosition(arr[index], index));
		}

		Collections.sort(list, new Comparator<DataPosition>() {

			public int compare(DataPosition obj1, DataPosition obj2) {
				return obj1.getData() - obj2.getData();
			}
		});

		int currentIndex = 0;
		int totalSwaps = 0;
		int localSwaps = 0;

		for (int index = 0; index < arr.length; index++) {
			if (visited[index] || index == list.get(index).getPosition())
				continue;

			currentIndex = index;
			localSwaps = 0;
			while (!visited[currentIndex]) {
				visited[currentIndex] = true;
				currentIndex = list.get(currentIndex).getPosition();
				localSwaps++;
			}

			totalSwaps += localSwaps > 0 ? localSwaps - 1 : 0;
		}
		return totalSwaps;
	}

	// Driver program to test the above function
	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5, 1 };

		System.out.println(minSwaps(a));
	}
}
