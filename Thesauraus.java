

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String str = br.readLine();

			long out_ = getCount(str);
			System.out.println(out_);
		}

		wr.close();
		br.close();
	}

	static long getCount(String str) {
		// Write your code here
		long count = 1;
		long modulo = 1000000007;
		char[] ar = str.toCharArray();
		long ch = 0;

		if (ar.length < 1) {
			return 0;
		} else if (ar.length == 1) {
			if (ar[0] == '?') {
				return 26;
			} else {
				return 0;
			}
		}

		if (ar[0] == '?' && ar[ar.length - 1] == '?') {

		} else if (ar[0] == '?') {
			ar[0] = ar[ar.length - 1];
			if (ar[1] != '?' && ar[1] == ar[ar.length - 1]) {
				return 0;
			}
		} else if (ar[ar.length - 1] == '?') {

			ar[ar.length - 1] = ar[0];
			if (ar[ar.length - 2] != '?' && ar[0] == ar[ar.length - 2]) {
				return 0;
			}
		}

		if (ar[0] == ar[ar.length - 1] || (ar[0] == '?') || (ar[ar.length - 1] == '?')) {

			int start = 0;

			for (int index = 1; index < ar.length; index++) {
				if (ar[index] == '?') {
					ch++;
				} else if (ch > 0) {
					count = (count * (calculate(ch, modulo, start, index, ar))) % modulo;
					ch = 0;
					start = index;
				} else if (index > 0 && ch == 0) {
					if (ar[index] == ar[index - 1]) {
						return 0;
					}
					start = index;
				}
			}

			count = (count * (calculate(ch, modulo, start, ar.length - 1, ar))) % modulo;

			return count;
		}
		return 0;
	}

	private static long calculate(long count, long modulo, int start, int end, char[] ar) {
		long last = 1;
		long total = 1;

		if (count == 0) {
			return 1;
		}
		if (ar[start] == ar[end]) {
			last = 0;
		}

		if (count == ar.length - 1 && start == 0) {
			total = 650;
			if (count == 1) {
				return 26;
			}
			if (count == 2) {
				return total;
			}
			last = 650;
			count = count - 2;
		}

		// System.out.println(count);
		while (count > 0) {
			total = (total * 25) % modulo;
			last = (total - last) % modulo;
			count--;
		}
		return last;
	}
}
