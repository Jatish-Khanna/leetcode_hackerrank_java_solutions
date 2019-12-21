

public class Solution { 
     public String reverseWords(String s) {
        String []words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder sbTemp;
        for(String word : words) {
            sbTemp = new StringBuilder(word);
            sb.append(sbTemp.reverse());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
