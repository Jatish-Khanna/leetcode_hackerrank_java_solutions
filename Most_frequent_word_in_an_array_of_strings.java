import java.util.HashMap;

class Solution {

	private static void findWinnerWithMostVotes(String[] votes) {
		if (votes == null)
			return;

		HashMap<String, Integer> findWinner = new HashMap<>();
		int winVotes = 0;
		String winnerName = "";
		for (String vote : votes) {
			findWinner.put(vote, findWinner.getOrDefault(vote, 0) + 1);
			if (findWinner.get(vote) > winVotes) {
				winVotes = findWinner.get(vote);
				winnerName = vote;
			}
		}

		System.out.println("Person won: " + winnerName + " with votes - " + winVotes);
	}

	// Driver code
	public static void main(String[] args) {
		String[] votes = { "john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john", "johnny",
				"jamie", "johnny", "john" };

		findWinnerWithMostVotes(votes);
	}
}
