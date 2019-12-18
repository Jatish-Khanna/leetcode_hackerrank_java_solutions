
public class Solution {

   public int maxNumberOfBalloons(String text) {
        int []freq = new int[26];
        for(char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }
        return Math.min(Math.min(Math.min(freq[0], freq[1]), Math.min(freq[11] / 2, freq[13])), freq[14] / 2);
    }
}
