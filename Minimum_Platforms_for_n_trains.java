import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		int arrival[] = { 900, 940, 950, 1100, 1500, 1800 };
		int departure[] = { 1110, 1200, 1120, 1130, 1900, 2000 };
		int n = arrival.length;
		System.out.println("Platforms Required = " + findPlatform(arrival, departure, n));
	}

	/**
	 * Number of platforms required for arrived trains during time event
	 * @param arrival time events when trains arrive (sorted)
	 * @param departure time events when arrived train departs
	 * @param n number of trains
	 * @return maximum number of platforms required for n trains
	 */
	private static int findPlatform(int[] arrival, int[] departure, int n) {
		// current platforms
		int numberOfPlatformsRequired = 0;
		// maximum platforms required
		int maximumPlatforms = 0;
		// time events are usually in sorted order
//		Arrays.sort(arrival);
		// departures should be sorted
		Arrays.sort(departure);

		int indexArrival = 0;
		int indexDeparture = 0;

		// for all the train events sorted - irrelevant of arrival and departure
		while (indexArrival < n && indexDeparture < n) {
			// Train has arrived now before other train departs
			if (arrival[indexArrival] < departure[indexDeparture]) {
				// Extra platform required
				numberOfPlatformsRequired++;
				// Check existing platforms are sufficient?
				maximumPlatforms = Math.max(maximumPlatforms, numberOfPlatformsRequired);
				indexArrival++;
			} else {
				// Train departs - platform is empty
				numberOfPlatformsRequired--;
				indexDeparture++;
			}
		}
		return maximumPlatforms;
	}
}
