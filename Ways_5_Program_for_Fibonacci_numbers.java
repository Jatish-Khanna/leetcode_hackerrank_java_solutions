class Solution {
	public static void main(String args[]) {
		int N = 9;
		// Naive
		System.out.println("Nth Fibonacci number " + fibonacciSeries1Recussion(N));

		// Optimal using DPSolution
		System.out.println("Nth Fibonacci number " + fibonacciSeries2DpSolution(N));

		// Improved space complexity
		System.out.println("Nth Fibonacci number " + fibonacciSeries3SpaceEfficient(N));

		// Matrix solution with O(n) and O(1)
		System.out.println("Nth Fibonacci number " + fibonacciSeries4MatrixSolution(N));

		// Matrix optimized with log n solution
		System.out.println("Nth Fibonacci number " + fibonacciSeries5MatrixOptimiizedLognSolution(N));
	}

	private static long fibonacciSeries1Recussion(int n) {
		if (n <= 1)
			return n;
		return fibonacciSeries1Recussion(n - 1) + fibonacciSeries1Recussion(n - 2);
	}

	private static long fibonacciSeries2DpSolution(int n) {
		if (n <= 1)
			return n;

		int[] dpSol = new int[n + 1];
		dpSol[1] = 1;

		for (int index = 2; index <= n; index++) {
			dpSol[index] = dpSol[index - 1] + dpSol[index - 2];
		}

		return dpSol[n];
	}

	private static long fibonacciSeries3SpaceEfficient(int n) {
		if (n <= 1)
			return n;

		int fibLast = 1;
		int fib2ndLast = 0;
		int fibNumber = 0;

		for (int index = 2; index <= n; index++) {
			fibNumber = fib2ndLast + fibLast;
			fib2ndLast = fibLast;
			fibLast = fibNumber;
		}
		return fibNumber;
	}

	private static long fibonacciSeries4MatrixSolution(int n) {
		if (n <= 1)
			return n;
		long solution[][] = { { 1, 1 }, { 1, 0 } };
		long multiplier[][] = { { 1, 1 }, { 1, 0 } };

		for (int index = 2; index < n; index++) {
			fibPowerFunction(solution, multiplier);
		}
		return solution[0][0];
	}

	private static void fibPowerFunction(long[][] solution, long[][] multiplier) {
		long x = solution[0][0] * multiplier[0][0] + solution[0][1] * multiplier[1][0];
		long y = solution[0][0] * multiplier[0][1] + solution[0][1] * multiplier[1][1];
		long z = solution[1][0] * multiplier[0][0] + solution[1][1] * multiplier[1][0];
		long u = solution[1][0] * multiplier[0][1] + solution[1][1] * multiplier[1][1];
		solution[0][0] = x;
		solution[0][1] = y;
		solution[1][0] = z;
		solution[1][1] = u;
	}

	private static long fibonacciSeries5MatrixOptimiizedLognSolution(int n) {
		if (n <= 1)
			return n;
		long solution[][] = { { 1, 1 }, { 1, 0 } };

		fibPowerFunctionOptimized(solution, n - 1);
		return solution[0][0];
	}

	private static void fibPowerFunctionOptimized(long[][] solution, int n) {
		if (n <= 1)
			return;
		long multiplier[][] = { { 1, 1 }, { 1, 0 } };

		fibPowerFunctionOptimized(solution, n / 2);
		fibPowerFunction(solution, solution);
		if (n % 2 != 0)
			fibPowerFunction(solution, multiplier);
	}
}
