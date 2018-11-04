
import java.util.Scanner;
class Solution {
	static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

//		int walls = in.nextInt();
		int[] arr = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };// new int[walls];
		int walls = arr.length;
//		for (int index = 0; index < walls; index++) {
//			arr[index] = in.nextInt();
//		}
		calculateMaxDistance(arr, walls);
		calculateMaxDistanceOptimized(arr, walls);

		in.close();
	}

	/**
	 * Calculate maximum distance between two indexes where a[i] < ar[j] & i < j
	 * O(N)
	 * @param arr stores the list of data
	 * @param walls number of elements
	 */
	private static void calculateMaxDistanceOptimized(int[] arr, int walls) {
		int[] left = new int[walls];
		int[] right = new int[walls];
		left[0] = arr[0];
		right[walls - 1] = arr[walls - 1];
		
		// Calculate smallest element till now 
		for (int index = 1; index < walls; index++) {
			left[index] = Math.min(left[index - 1], arr[index]);
		}

		// Maximum element till now seen
		for (int index = walls - 2; index >= 0; index--) {
			right[index] = Math.max(right[index + 1], arr[index]);
		}

		int leftIndex = 0;
		int rightIndex = 0;
		int maxDistance = 0;
		// While end of left lower or higher right
		while (leftIndex < walls && rightIndex < walls) {
			// If current element is lower than right (max found for index)
			if (left[leftIndex] < right[rightIndex]) {
				maxDistance = Math.max(maxDistance, rightIndex - leftIndex);
				rightIndex++;
			} else {
				// else check next lower element
				leftIndex++;
			}
		}
		System.out.println(maxDistance);
	}
	// O(N)2
	private static void calculateMaxDistance(int[] arr, int walls) {
		int maxDistance = 0;

		for (int index = 0; index < walls - 1; index++) {
			for (int next = walls - 1; next > index; next--) {
				if (arr[index] < arr[next]) {
					maxDistance = Math.max(maxDistance, next - index);
					break;
				}
			}
		}
		System.out.println(maxDistance);
	}
}
