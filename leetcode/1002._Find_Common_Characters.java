
public class Solution {

public List<String> commonChars(String[] A) {
        int []count = new int[26];
        
        Arrays.fill(count, Integer.MAX_VALUE);
        for(String str : A) {
            int []current = new int[26];
            for(char cr: str.toCharArray()) {
                current[cr-'a']++;
            }
            for(int index = 0; index < current.length; index++) {
                count[index] = Math.min(count[index], current[index]);
            }
        }
        List<String> result = new ArrayList<>();
        for(int index = 0; index < count.length; index++) {
            if(count[index] != Integer.MAX_VALUE) {
            while(count[index] > 0) {
                result.add(String.valueOf((char)('a'+index)));
                count[index]--;
            }
        }
        }
        return result;
    }
}
