

public class Solution {


// Faster when using StringBuilder instead of internal optimization of String class

    public String sortString(String s) {
       int []ar = new int[26];
        for(char ch : s.toCharArray()) {
            ar[ch - 'a']++;
        }
        
        StringBuilder ids = new StringBuilder();
        int index = 0;
        int count = 0;
        while(count < s.length()) {
            index = 0;
            while(index < ar.length && count < s.length()) {
                
                if(ar[index] > 0) {
                    ar[index]--;
                    ids.append((char)(index + 'a'));
                    count++;
                }
                
                index++;
                
            }
            
            while(--index >= 0 && count < s.length()) {
                if(ar[index] > 0) {
                    ar[index]--;
                    ids.append((char)(index + 'a'));
                    count++;
                }
                //--index;
                }
            }
        return ids.toString();
        }
    }
