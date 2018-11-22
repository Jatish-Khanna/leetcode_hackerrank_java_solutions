import java.util.Scanner;

public class Solution {

	static int[] rangeCheck;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int TEST = in.nextInt();

		for (int test = 0; test < TEST; test++) {
			rangeCheck = new int[5001];

			int cities = in.nextInt();
			for (int index = 0; index < cities; index++) {
				fillRange(in.nextInt(), in.nextInt());
			}

			int queries = in.nextInt();
			for (int query = 0; query < queries; query++) {
				System.out.print(rangeCheck[in.nextInt()] + " ");
			}
			System.out.println();
		}
		in.close();
	}

	private static void fillRange(int firstCity, int LastCity) {
		for (int city = firstCity; city <= LastCity; city++) {
			rangeCheck[city]++;
		}
	}
}
