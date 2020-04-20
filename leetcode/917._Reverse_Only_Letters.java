class Solution {
    public String reverseOnlyLetters(String S) {
        if(S.isEmpty()) { return ""; } 
       char []ch = S.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        boolean ic = check(ch[i]);
        boolean jc = check(ch[j]);
        char tmp;
        while(i < j) {
            if(!ic) {
                i++;
                ic = check(ch[i]);
            } else if(!jc) {
                j--;
                jc = check(ch[j]);
            } else {
                tmp = ch[i];
                ch[i] = ch[j];
                ch[j] = tmp;
                i++;
                j--;
                ic = check(ch[i]);
                jc = check(ch[j]);
            }
        }
        return new String(ch);
    }
    
    boolean check(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
	}
}
