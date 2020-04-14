

public class Solution {

    public int maximum69Number (int num) {
        String number = String.valueOf(num);
        char []ch = number.toCharArray();
        for(int index = 0; index < ch.length; index++) {
            if(ch[index] == '6') {
                ch[index] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(ch));
    }
}
