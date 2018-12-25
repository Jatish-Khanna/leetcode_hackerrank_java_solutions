class Solution {


	public static int findKthElementInSortedArray(int[] arr1, int iFirst, int m, int[] arr2, int iSecond, int n,
			int k) {

		if (k > (m + n) || k < 1)
			return -1;

		// let m <= n
		if (m > n)
			return findKthElementInSortedArray(arr2, iSecond, n, arr1, iFirst, m, k);

		// if arr1 is empty returning k-th element of arr2
		if (m == 0)
			return arr2[iSecond + k - 1];

		// if k = 1 return minimum of first two elements of both arrays
		if (k == 1)
			return Math.min(arr1[iFirst], arr2[iSecond]);

		// now the divide and conquer part
		int i = Math.min(m, k / 2), j = Math.min(n, k / 2);

		if (arr1[iFirst + i - 1] > arr2[iSecond + j - 1])
			// Now we need to find only k-j th element since we have found out the lowest j
			return findKthElementInSortedArray(arr1, iFirst, m, arr2, iSecond + j, n - j, k - j);
		else
			// Now we need to find only k-i th element since we have found out the lowest i
			return findKthElementInSortedArray(arr1, iFirst + i, m - i, arr2, iSecond, n, k - i);
	}

// Driver code 
	public static void main(String[] args) {
		int arr2[] = { 2, 3, 6, 7, 9 };
		int arr1[] = { 1, 4, 8, 10 };

		int k = 9;

		int kthElement = findKthElementInSortedArray(arr1, 0, arr1.length, arr2, 0, arr2.length, k);

		if (kthElement == -1)
			System.out.println("Invalid query");
		else
			System.out.println(kthElement);

	}
}
