class Solution {

	private static void nutboltmatch(char[] nuts, char[] bolts) {

		if (nuts.length != bolts.length)
			return;
		HashSet<Character> map = new HashSet<>();
		for (char nut : nuts) {
			map.add(nut);
		}

		for (char bolt : bolts) {
			if (map.contains(bolt)) {
				System.out.println("Bolt found: " + bolt);
			} else {
				System.out.println("Bolt not found.");
			}
		}
	}

// Driver code 
	public static void main(String[] args) {
		char nuts[] = { '@', '#', '$', '%', '^', '&' };
		char bolts[] = { '$', '%', '&', '^', '@', '#' };
		nutboltmatch(nuts, bolts);
	}
}
