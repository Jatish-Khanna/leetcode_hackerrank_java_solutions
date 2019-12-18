

public class Solution {

public int countCharacters(String[] words, String chars) {
        int []count = new int[26];
        for(char element : chars.toCharArray()) {
            count[element - 'a']++;
        }
        int []copy;
        int length = 0;
        boolean flag = false;
        for(String word : words) {
            copy = Arrays.copyOf(count, count.length);
            for(char element : word.toCharArray()) {
                copy[element - 'a']--;
                if(copy[element - 'a'] < 0) {
                    flag = true;
                    break;
                }
            }
            length += flag ? 0 : word.length();
                flag = false;
        }
        return length;
    }
}
