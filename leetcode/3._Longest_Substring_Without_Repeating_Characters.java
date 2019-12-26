

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int ans = 0;
        for(int index = 0; index < s.length(); index++) {
            if(map.containsKey(s.charAt(index))) {
              start = Math.max(start, map.get(s.charAt(index)));   
            }
            ans = Math.max(ans, index - start + 1);
            map.put(s.charAt(index), index + 1);
        }
        return ans;
    }
}
