

public class Solution {
    
    // Faster method without integer to string conversion
    
    public int maximum69Number (int num) {
        int sum = 3;
        for(int div = 1000; div > 0; div = div/10) {
            if((num / div)%10 == 6) {
                return num + sum * div;
            }
        }
        return num;
    }


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
