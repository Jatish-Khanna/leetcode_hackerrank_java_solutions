class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int citiesPlannedByFirst = in.nextInt();
		int citiesPlannedBySecond = in.nextInt();
		int commonCitiesPlanned = in.nextInt();

		int uniqueCities = citiesPlannedByFirst + citiesPlannedBySecond - commonCitiesPlanned;
		// Final destination is same for both the persons
		long totalWaysToPlanDestination = ways(uniqueCities - 1);
		System.out.println(totalWaysToPlanDestination);
		in.close();
	}

	private static long ways(int cities) {
		long result = 1l;
		while (cities > 1) {
			result *= cities;
			cities--;
		}

		return result;
	}
}
