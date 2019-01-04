class Solution {

	private static void findCommonElementsInThreeSorterArrays(int[] ar1, int[] ar2, int[] ar3) {
		int indexFirst = 0;
		int indexSecond = 0;
		int indexThird = 0;

		while (indexFirst < ar1.length && indexSecond < ar2.length && indexThird < ar3.length) {
			if (ar1[indexFirst] == ar2[indexSecond] && ar1[indexFirst] == ar3[indexThird]) {
				System.out.println(ar1[indexFirst] + "\t" + indexFirst + "\t" + indexSecond + "\t" + indexFirst);
				indexFirst++;
				indexSecond++;
				indexThird++;
			}

			else if (ar1[indexFirst] < ar2[indexSecond]) {
				indexFirst++;
			} else if (ar3[indexThird] < ar2[indexSecond]) {
				indexThird++;
			} else {
				indexSecond++;
			}
		}
	}

	// Driver code to test above
	public static void main(String args[]) {

		int ar1[] = { 1, 5, 10, 20, 40, 80 };
		int ar2[] = { 6, 7, 20, 80, 100 };
		int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

		System.out.println("Common elements are ");
		System.out.println("Element\tAr1\tAr2\tAr3");
		findCommonElementsInThreeSorterArrays(ar1, ar2, ar3);
	}
}
