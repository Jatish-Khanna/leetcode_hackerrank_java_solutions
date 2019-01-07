class Solution {

	static final char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	private static String idToShortURL(int number) {

		StringBuilder shorturl = new StringBuilder();
		while (number > 0) {
			shorturl.append(map[number % 62]);
			number /= 62;
		}
		return shorturl.reverse().toString();
	}

	private static long shortURLtoID(String shorturl) {

		long number = 0;
		char current = '\u0000';

		for (int index = 0; index < shorturl.length(); index++) {
			current = shorturl.charAt(index);
			if ('a' <= current && current <= 'z') {
				number = number * 62 + current - 'a';
			} else if ('A' <= current && current <= 'Z') {
				number = number * 62 + current - 'A' + 26;
			} else if ('0' <= current && current <= '9') {
				number = number * 62 + current - '0' + 52;
			}
		}
		return number;
	}

// Driver program to test above function 
	public static void main(String[] args) {
		int n = 12345;
		String shorturl = idToShortURL(n);
		System.out.println("Generated short url is " + shorturl);
		System.out.println("Id from url is " + shortURLtoID(shorturl));
	}
}
