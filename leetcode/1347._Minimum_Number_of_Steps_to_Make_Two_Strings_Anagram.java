class Solution {
    public int minSteps(String s, String t) {
        int[] ar = new int[26];
        for(char ch : s.toCharArray()) {
            ar[ch - 'a']++;
        }
        
        int count = s.length();
        for(char ch : t.toCharArray()) {
            if(ar[ch - 'a']-- > 0) {
                count--;
            } else {
                count++;
            }
        }
        
        
        // for(int index = 0; index < ar.length; index++) {
        //     count += Math.abs(ar[index]);
        // }
        // return count/2;
        return count/2;
    }
}
