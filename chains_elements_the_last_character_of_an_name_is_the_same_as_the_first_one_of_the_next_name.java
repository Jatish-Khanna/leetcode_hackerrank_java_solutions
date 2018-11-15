import java.util.HashMap;
improt java.util.LinkedList;
import java.util.List;

class Solution {


	// Inner class to store details for each string, start char and end char
	private static class Names {
		String name;
		char start;
		char end;

		public Names(String name, char start, char end) {
			this.name = name;
			this.start = start;
			this.end = end;
		}
	}

	// Driver program to create a chain and print it
	public static void main(String[] args) {
		String[] names = { "Raymond", "Nora", "Daniel", "Louie", "Peter", "Esteban" };
		List<String> chain = createChain(names, names.length);
		chain.stream().forEach(System.out::println);
	}

	/**
	 * Create a chain of character starting, each word is connected - end character
	 * of last string is same as first character of next
	 * 
	 * @param names  list of items for which a chain needs to be created
	 * @param length number of items
	 * @return a chain created
	 */
	private static List<String> createChain(String[] names, int length) {

		// Result chain
		LinkedList<String> chain = new LinkedList<>();
		// A key map for startWith character of string
		HashMap<Character, Names> startsWith = new HashMap<>();
		// A key map for endWith character of string
		HashMap<Character, Names> endsWith = new HashMap<>();

		// Temporary variables to store start and end char
		char startChar = '\u0000';
		char endChar = '\u0000';
		Names tmp;

		// Iterate over each name
		for (String name : names) {
			// Get starting char or chatAt(0)
			startChar = Character.toLowerCase(name.charAt(0));
			// Get ending char or chatAt(length - 1)
			endChar = name.charAt(name.length() - 1);
			// Create a node stores details of start, end and name
			Names nm = new Names(name, startChar, endChar);

			// Build startsWith map
			startsWith.put(startChar, nm);
			// Build endsWith map
			endsWith.put(endChar, nm);

		}

		// Add first known node
		chain.add(startsWith.get(startChar).name);

		// Build chain for all known characters
		while (chain.size() < Math.min(startsWith.size(), endsWith.size())) {
			// if string found that ends with - starting character of string
			if (endsWith.containsKey(startChar)) {
				// Get the node
				tmp = endsWith.get(startChar);
				// Add the name to chain
				chain.addFirst(tmp.name);
				// Update start char as - start of new string appended to chain
				startChar = tmp.start;
			}
			// if string found that starts with - ending character of string
			if (startsWith.containsKey(endChar)) {
				// Get the node
				tmp = startsWith.get(endChar);
				// Add the name to chain
				chain.addLast(tmp.name);
				// Update the end char as - end of new String appended to chain
				endChar = tmp.end;
			}
		}
		// return chain
		return chain;
	}
}
