

public class Solution {

    public int firstUniqChar(String s) {
        int []ar = new int[26];
        char []ch = s.toCharArray();
        
        for(char val : ch) {
            ar[val - 'a']++;
        }
       // int index = 0;
        for(int index  = 0; index < ch.length; index++) {
            if(ar[ch[index] - 'a'] == 1) {
                return index; 
            }
        }
        return -1;
    }
}
