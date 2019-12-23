
public class Solution {

   public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char ch;
        while(left < right) {
            ch = s[left];
            s[left++] = s[right];
            s[right--] = ch;
        }
    }
}
