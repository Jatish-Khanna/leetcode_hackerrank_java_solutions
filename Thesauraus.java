

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

		if (ar.length <= 1) {
			return 0;
		}

		if (ar[0] == '?' && ar[ar.length - 1] == '?') {
			if (ar[1] != ar[ar.length - 2]) {
				count = 24;
			} else {
				count = 25;
			}
		} else if (ar[0] == '?' && ar[1] != '?' && ar[1] == ar[ar.length - 1]) {
			return 0;
		} else if (ar[ar.length - 1] == '?' && ar[ar.length - 2] != '?' && ar[0] == ar[ar.length - 2]) {
			return 0;
		}

		if (ar[0] == ar[ar.length - 1] || (ar[0] == '?') || (ar[ar.length - 1] == '?')) {

			int start = 0;

			for (int index = 1; index < ar.length - 1; index++) {
				if (ar[index] == '?') {
					ch++;
				} else if (ch > 1) {
					count = (count * (calculate(ch, modulo, ar[start] == ar[index]))) % modulo;
					ch = 0;
					start = index;
				} else if (ch == 1) {
					count = (count * (ar[start] == ar[index] ? 25 : 24)) % modulo;
					ch = 0;
					start = index;
				} else if (ch == 0) {
					if (ar[index] == ar[index - 1]) {
						return 0;
					}
					start = index;
				}
			}

			count = (count * (calculate(ch, modulo, ar[start] == ar[ar.length - 2]))) % modulo;
			return count;
		}
		return 0;
	}

	private static long calculate(long count, long modulo, boolean same) {
		if (count == 0) {
			return 1;
		}
		long last = 24;
		if (same) {
			last = 25;
		}
		long total = 25;
		// System.out.println(count);
		while (count > 0) {
			total = (total * 25) % modulo;
			last = (total - last) % modulo;
			count--;
		}
		return (total - last) % modulo;
	}
