

public class Solution {
    
  // No using Arrays.fill(-1)  
  public int lengthOfLongestSubstring(String s) {
        int[] last = new int[256];
        int result = 0;
        // Arrays.fill(last, -1);
        
        int N = s.length();
        int start = 0;
        for(int i = 0 ; i < N ; ++i) {
            start = Math.max(start, last[s.charAt(i)]);
            
            result = Math.max(result, i - start + 1);
            last[s.charAt(i)] = i + 1;
        }
        return result;
    }

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
