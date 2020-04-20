class Solution {
    
    // same speed
    public boolean detectCapitalUse(String word) {
        
        if(word.length() == 1) {
            return true;
        }
       
        if(!caps(word.charAt(0)) && caps(word.charAt(1))) {
            return false;
        }
        
        if(caps(word.charAt(1))) {
            for(int index = 2; index < word.length(); index++) {
                if(!caps(word.charAt(index))) {
                    return false;
                }
            }
        } else {
             for(int index = 2; index < word.length(); index++) {
                if(caps(word.charAt(index))) {
                    return false;
                }
            }
            
        }
        return true;
    }
   
    
    // same speed
    
    
    public boolean detectCapitalUse(String word) {
        char ch[] = word.toCharArray();
        int count = 0;
        for(char w : ch) {
            if(caps(w)) {
                count++;
            }
        }
        return count == ch.length || count == 0 || (count == 1 && caps(ch[0]));
    }
    
    public boolean caps(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}
