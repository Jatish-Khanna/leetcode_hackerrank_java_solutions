import java.util.IntSummaryStatistics;
import java.util.Arrays;
import java.util.Scanner;


class Solution {
	static int[] parents = new int[30001];
	static int[] ranks = new int[30001];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int edgeCount = in.nextInt();
		int first;
		int second;

		Arrays.fill(ranks, 1);

		for (int edge = 0; edge < edgeCount; edge++) {
			first = in.nextInt();
			second = in.nextInt();

			union(first, second);
		}

		IntSummaryStatistics statistics = Arrays.stream(ranks).filter(number -> number != 0 && number != 1)

				.summaryStatistics();
		System.out.println(statistics.getMin() + " " + statistics.getMax());

		in.close();
	}

	private static void union(int first, int second) {
		int parentF = findParent(first);
		int parentS = findParent(second);

		if (parentF == parentS) {
			return;
		}

		parents[parentS] = parentF;
		ranks[parentF] += ranks[parentS];
		ranks[parentS] = 0;
	}

	private static int findParent(int id) {
		if (parents[id] == id || parents[id] == 0) {
			return id;
		}

		parents[id] = findParent(parents[id]);
		return parents[id];
	}
}
