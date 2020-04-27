class Solution {
    public String freqAlphabets(String s) {
        char []ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int index = ch.length - 1; index >= 0; index--) {
            if(ch[index] == '#') {
                sb.append((char)((10 * (ch[index - 2] - '0') + (ch[index - 1] - '0')) + '`'));
                index -= 2;
            } else {
                sb.append((char)((ch[index] - '0') + '`'));
            }
        }
        return sb.reverse().toString();
    }
}
