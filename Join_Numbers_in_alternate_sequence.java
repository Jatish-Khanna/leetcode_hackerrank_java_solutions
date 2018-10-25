class Solution {

	final static int LIMIT = 9;

	/**
	 * Entry point for the algorithm to zip two numbers
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(zipNumbers(135, 460000));
	}

	/**
	 * Zip two numbers where final number should be < 1_000_000_000
	 * @param first number one
	 * @param second number two
	 * @return Zipped string 
	 */
	private static String zipNumbers(int first, int second) {
		StringBuilder build = new StringBuilder();
		char[] firstArray = createArray(first);
		char[] secondArray = createArray(second);

		int totalLength = firstArray.length + secondArray.length;
		
		if(totalLength > LIMIT)
			return "-1";
		
		int index = 0;
		while (index < firstArray.length && index < secondArray.length) {
			build.append(firstArray[index]);
			build.append(secondArray[index]);
			index++;
		}

		while (index < firstArray.length) {
			build.append(firstArray[index]);
			index++;
		}

		while (index < secondArray.length) {
			build.append(secondArray[index]);
			index++;
		}
		return build.toString();
	}

	private static char[] createArray(int number) {
		return String.valueOf(number).toCharArray();
	}

}
