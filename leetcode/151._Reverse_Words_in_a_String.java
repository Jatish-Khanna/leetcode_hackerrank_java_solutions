

public class Solution {

    public String reverseWords(String s) {
        if(s == null || s.equals("")) { return ""; }
        String []ar = s.split(" ");
        String last = "";
        int start = 0; 
        int end = ar.length;
        StringBuilder sb = new StringBuilder();
        for(int index = ar.length -1 ; index >= 0; index--) {
            if(ar[index].equals("")) { continue; }
            sb.append(ar[index]).append(" ");
        }
        if(sb.length() > 0) {
        sb.deleteCharAt(sb.length() - 1); 
        }
        return sb.toString();
    }
}
