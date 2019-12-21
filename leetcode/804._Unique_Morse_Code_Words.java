

public class Solution {
public int uniqueMorseRepresentations(String[] words) {
         String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String word : words) {
            set.add(convertMorseCode(word, codes));
        }
        return set.size();
    }
    
    public String convertMorseCode(String word, String []codes) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : word.toCharArray()) {
            sb.append(codes[ch - 'a']);
        }
        return sb.toString();
    }
}
