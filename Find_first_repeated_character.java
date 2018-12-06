class Solution {


	private static char firstRepeating(char[] arr) {
		boolean[] dictionary = new boolean[256];

		for (int index = 0; index < arr.length; index++) {
			if (dictionary[arr[index]]) {
				return arr[index];
			} else {
				dictionary[arr[index]] = true;
			}
		}
		return '\u0000';
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		char[] arr = str.toCharArray();
		System.out.println(firstRepeating(arr));
	}
}
