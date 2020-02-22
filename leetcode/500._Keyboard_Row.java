
public class Solution {
    public String[] findWords(String[] words) {
        String first = "qwertyuiopQWERTYUIOP";
        String second = "asdfghjklASDFGHJKL";
        String third = "zxcvbnmZXCVBNM";
        
        Map<Character, Integer> map = new HashMap<>();
        putMap(first, 1, map);
        putMap(second, 2, map);
        putMap(third, 3, map);
        
        boolean required;
        List<String> list = new ArrayList<>();
        for(String word : words) {
            required = true;
            int type = map.get(word.charAt(0));
            for(int index = 1; index < word.length(); index++) {
                if(map.get(word.charAt(index)) != type) { required = false; break; }
            }
            
            if(required) {
                list.add(word);
            }
        }
        String []result = new String[list.size()];
        int index = 0;
        for(String word : list) {
            result[index++] = word;
        }
        return result;
    }
    
    private void putMap(String string, int value, Map<Character, Integer> map) {
        for(char ch : string.toCharArray()) {
            map.put(ch, value);
        }
    }
}
