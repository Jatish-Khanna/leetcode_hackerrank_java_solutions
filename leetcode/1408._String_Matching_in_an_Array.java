class Solution {
    public List<String> stringMatching(String[] words) {
        HashSet<String> substr = new HashSet<>();
        HashSet<String> list = new HashSet<>();
        for(String word : words) {
            substr.add(word);
        }
        for(String word : words) {
            for(int index = 0; index < word.length() - 1; index++) {
                for(int j = index + 1; j <= word.length(); j++) {
                    if(j - index == word.length()) {
                        continue;
                    }
                    //System.out.println(word.substring(index, j));
                    if(substr.contains(word.substring(index, j))) {
                        list.add(word.substring(index, j));
                    }
                }
            }
        }
        
        return new ArrayList<>(list);
    }
}
