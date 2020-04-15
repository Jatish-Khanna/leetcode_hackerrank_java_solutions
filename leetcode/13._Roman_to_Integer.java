

public class Solution {


    public int romanToInt(String s) {
        char []ch = s.toCharArray();
        int v1;
        int v2;
        int result = 0;
        for(int index = 0; index < ch.length - 1; index++) {
            v1 = getValue(ch[index]);
            v2 = getValue(ch[index + 1]);
            
            if(v1 >= v2) {
                result += v1;
            } else {
                result -= v1;
            }
        }
        return result + getValue(ch[ch.length - 1]);
    }
    
    private int getValue(char x){
        switch(x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
