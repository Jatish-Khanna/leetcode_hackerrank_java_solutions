class Solution {
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
