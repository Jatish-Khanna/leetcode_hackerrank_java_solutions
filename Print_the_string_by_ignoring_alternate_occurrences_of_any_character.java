class Solution {

	private static void printStringAlternate(String record) {
		if(record == null || "".equals(record))
			return;
		
		Map<Character, Integer> frequencyMap = new HashMap<>();
		
		char current = '\u0000';
		char original = '\u0000';
		for(int index = 0; index < record.length(); index++) {
			current = Character.toLowerCase(record.charAt(index));
			original = record.charAt(index);
			frequencyMap.put(current, frequencyMap.getOrDefault(current, 0) + 1);
			if(frequencyMap.get(current) % 2 != 0) {
				System.out.print(original);
			}
		}
		System.out.println();
	}

    // driver program 
    public static void main (String[] args)  
    { 
        String str1 = "Geeks for geeks"; 
        String str2 = "It is a long day Dear"; 
        printStringAlternate(str1); 
        printStringAlternate(str2); 
    } 
}
