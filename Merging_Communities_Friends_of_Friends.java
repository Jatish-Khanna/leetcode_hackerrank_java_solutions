import java.util.Arrays;
import java.util.Scanner;

class Solution {

	// To store parent of each node
	static int parents[];
	// Rank of each node i.e. number of nodes connected to root of tree
	static int ranks[];

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int people = in.nextInt();
		int queries = in.nextInt();
		
		// Initialize parents and ranks
		parents = new int[people + 1];
		ranks = new int[people + 1];

		// Each person holds rank - 1 i.e. individual node
		Arrays.fill(ranks, 1);
		// Each node is parent to itself
		for (int index = 1; index <= people; index++) {
			parents[index] = index;
		}

		String type;
		int personIdOne;
		int personIdTwo;
		
		// Iterate over each query
		for (int query = 0; query < queries; query++) {
			type = in.next();

			// Select operation
			switch (type) {
			case "Q":
				// Get the Id for which rank or size of connected components to be found
				personIdOne = in.nextInt();
				// Find nodes parent and print rank of parent
				System.out.println(ranks[find(personIdOne)]);
				break;
			case "M":
				// Get Id's which should be connection or union
				personIdOne = in.nextInt();
				personIdTwo = in.nextInt();
				// Union both the ID's
				union(personIdOne, personIdTwo);
				break;
			default:
				break;
			}
		}
		in.close();
	}

	/**
	 * Two id's should be concatenated and to be mentored under same parent 
	 * @param personIdOne first ID
	 * @param personIdTwo second ID
	 */
	private static void union(int personIdOne, int personIdTwo) {
		
		// Find the parent of first node
		int parentPersonOne = find(personIdOne);
		// Find the parent of second node
		int parentPersonTwo = find(personIdTwo);

		// If parent of nodes are same, nodes are already connected - complete
		if (parentPersonOne == parentPersonTwo) {
			return;
		}
		
		// Check node parent node with higher number of connected components
		if (ranks[parentPersonOne] > ranks[parentPersonTwo]) {
			// New parent of node with smaller nodes is node with higher rank or connected components
			parents[parentPersonTwo] = personIdOne;
			// Size of new connected components under parent - is sum of size of both the components
			ranks[parentPersonOne] = ranks[parentPersonTwo] + ranks[parentPersonOne];
		} else {
			parents[parentPersonOne] = personIdTwo;
			ranks[parentPersonTwo] = ranks[parentPersonTwo] + ranks[parentPersonOne];
		}

	}

	/**
	 * Find the parent of node
	 * @param personIdOne for which parent to be found
	 * @return parentId of argument node
	 */
	private static int find(int personIdOne) {
		// Get parent of node
		int parent = parents[personIdOne];
		// if node and parent of node is same return node as parent
		if (parent != personIdOne) {
			// recursively find parent of parents node and update parent of current node to recurssion end
			parents[personIdOne] = find(parent);
		}
		
		// return parent of node
		return parents[personIdOne];
	}
}
