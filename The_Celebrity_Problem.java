class Solution {

	// Person with 2 is celebrity
	static int MATRIX[][] = { { 0, 0, 1, 0 }, 
							{ 0, 0, 1, 0 }, 
							{ 0, 0, 0, 0 }, 
							{ 0, 0, 1, 0 } };

	private static int findCelebrity(int numberOfPersons) {

		int knownCelebrityFromFirst = 0;
		int knownCelebrityFromLast = numberOfPersons - 1;

		while (knownCelebrityFromFirst < knownCelebrityFromLast) {
			if (firstKnowsLast(knownCelebrityFromFirst, knownCelebrityFromLast)) {
				knownCelebrityFromFirst++;
			} else {
				knownCelebrityFromLast--;
			}
		}

		for (int person = 0; person < numberOfPersons; person++) {
			if (person != knownCelebrityFromFirst && (firstKnowsLast(knownCelebrityFromFirst, person)
					|| !firstKnowsLast(person, knownCelebrityFromFirst))) {
				return -1;
			}
		}
		return knownCelebrityFromFirst;
	}

	private static boolean firstKnowsLast(int first, int last) {
		return MATRIX[first][last] == 1;
	}

	// Driver Code
	public static void main(String[] args) {
		int n = 4;
		int result = findCelebrity(n);
		if (result == -1) {
			System.out.println("No Celebrity");
		} else
			System.out.println("Celebrity ID " + result);
	}
}
