class Solution {
    public int compress(char[] chars) {
        int index = 1;
        int count = 0;
        int pointer = 0;
        
        while(index <= chars.length) {
            count++;
            if(index == chars.length || chars[index] != chars[index - 1]) {
                chars[pointer++] = chars[index - 1];
                if(count > 1) {
                    for(char ch : String.valueOf(count).toCharArray()) {
                        chars[pointer++] = ch;
                    }
                }
                count = 0;
            }
            index++;
        }
        return pointer;
    }
}
