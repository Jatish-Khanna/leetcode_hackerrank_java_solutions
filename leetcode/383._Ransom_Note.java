

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int []dict = new int[26];
        
        for(char ch : magazine.toCharArray()) {
            dict[ch - 'a']++;
        }
        
        for(char ch : ransomNote.toCharArray()) {
            if(dict[ch - 'a'] > 0) {
                --dict[ch - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}
