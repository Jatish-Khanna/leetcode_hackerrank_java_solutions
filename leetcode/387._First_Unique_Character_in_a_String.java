

public class Solution {
    
    // Little optimization 
    
    public int firstUniqChar(String s) {
        int []ar = new int[26];
        //char []ch = ;
        
        int index = 1;
        int id;
        int max = s.length() + 1;
        for(char val : s.toCharArray()) {
            id = val - 'a';
            if(ar[id] != max && ar[id] > 0) {
                ar[id] = max;
            } else if(ar[id] == 0){
                ar[id] = index;
            }
            index++;
        }
        
        int min = max;
        for(int i = 0; i < 26; i++) {
            if(ar[i] > 0 && min > ar[i])
              min = ar[i];
        }
        return min == max ? -1 : min - 1;
    }

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
