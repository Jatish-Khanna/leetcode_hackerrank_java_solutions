class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String word : banned) {
            ban.add(word);
        }
        
        Set<Character> punctuation = new HashSet<>(Arrays.asList('!', '?', ';', '.', ',',  '\'', ' '));
	StringBuilder filtered = new StringBuilder();
        // List<String> list = new ArrayList<>();
	for (char ch : paragraph.toCharArray()) {
        if(!punctuation.contains(ch)) {
            filtered.append(Character.toLowerCase(ch));    
        } else {
             filtered.append(" ");
        }
		
    }
	paragraph = filtered.toString();
        
        String max = "";
        int freq = 0;
        for(String word : paragraph.split(" ")) {
            
            if(word.isEmpty()) { continue; }
            // word = word.toLowerCase();
            
            if(!ban.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                //System.out.println(map);
                if(freq < map.get(word)) {
                    freq = map.get(word);
                    max = word;
                }
            }
            
        }
         return max;
    }
}
