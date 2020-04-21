class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char []ar = typed.toCharArray();
        char []nar = name.toCharArray();
        
        int i = 1;
        int j = 1;
        
        if(ar[0] != nar[0]) {
            return false;
        }
        
        while(i < ar.length) {
            if(j < nar.length && nar[j] == ar[i]) {
                j++;
            } else if(ar[i] != ar[i - 1]) {
                return false;
            }
            i++;
        }
        
        return j == nar.length;
    }
}
