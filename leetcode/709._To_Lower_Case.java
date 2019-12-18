

public class Solution {

   public String toLowerCase(String str) {
      char []ar = new char[str.length()];
        int index = 0;
        for(char ch : str.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                ar[index] = Character.toLowerCase(ch);
            } else {
                ar[index] = ch;
            }
            index++;
        }
        return new String(ar);
    }
}
