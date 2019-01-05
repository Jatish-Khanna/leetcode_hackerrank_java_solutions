class Solution {


	static final int ALPHABET_SIZE = 26;
	static final char ALPHABET_START_CHAR = 'A';

	static class Trie {
		List<String> wordsStartingWithCharacter;
		Trie[] children = new Trie[ALPHABET_SIZE];
		boolean isLeaf;

		Trie() {
			wordsStartingWithCharacter = new ArrayList<>();
		}
	}

	static Trie trieNode;

	private static void findAllWords(List<String> dictionary, String pattern) {
		if (pattern == null || "".equals(pattern))
			return;
		if (dictionary == null || dictionary.isEmpty())
			return;

		buildTrie(dictionary);
		Trie resultList = searchPatternInTrie(pattern);
		if (resultList == null)
			System.out.println("No match found");
		else
			printMatchers(resultList);
	}

	private static void printMatchers(Trie resultList) {
		if (resultList.isLeaf) {
			for (String word : resultList.wordsStartingWithCharacter) {
				System.out.println(word);
			}

		}
		Trie[] crawlerChildren = resultList.children;
		for (int index = 0; index < ALPHABET_SIZE; index++) {
			if (crawlerChildren[index] != null) {
				printMatchers(crawlerChildren[index]);
			}
		}
	}

	private static Trie searchPatternInTrie(String pattern) {

		Trie crawler = trieNode;
		Trie[] crawlerChildren;
		int trieIndex;

		for (int index = 0; index < pattern.length(); index++) {
			if (Character.isLowerCase(pattern.charAt(index)))
				return null;
			crawlerChildren = crawler.children;
			trieIndex = pattern.charAt(index) - ALPHABET_START_CHAR;

			if (crawlerChildren[trieIndex] == null)
				return null;

			crawler = crawlerChildren[trieIndex];
		}
		return crawler;
	}

	private static void buildTrie(List<String> dictionary) {
		for (String wordInDictionary : dictionary) {
			insertInTrie(wordInDictionary);
		}
	}

	private static void insertInTrie(String wordInDictionary) {

		int trieIndex = 0;
		Trie crawler = trieNode;
		Trie[] crawlerChildren;

		for (int index = 0; index < wordInDictionary.length(); index++) {
			if (Character.isLowerCase(wordInDictionary.charAt(index)))
				continue;
			trieIndex = wordInDictionary.charAt(index) - ALPHABET_START_CHAR;
			crawlerChildren = crawler.children;

			if (crawlerChildren[trieIndex] == null) {
				crawlerChildren[trieIndex] = new Trie();
			}

			crawler = crawlerChildren[trieIndex];
		}

		crawler.isLeaf = true;
		crawler.wordsStartingWithCharacter.add(wordInDictionary);
	}

	// Driver function
	public static void main(String args[]) {

		// dictionary of words where each word follows
		// CamelCase notation
		List<String> dictionary = Arrays.asList("Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld",
				"HiTechCity", "HiTechLab");

		// pattern consisting of uppercase characters only
		String pattern = "HT";
		trieNode = new Trie();
		findAllWords(dictionary, pattern);
	}
}
