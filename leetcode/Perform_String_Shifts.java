

public class Solution {

    public String stringShift(String s, int[][] shift) {
        
        int amount = 0;
        for(int []ar : shift) {
            if(ar[0] == 0) {
                amount -= ar[1];
            } else {
                amount += ar[1];
            }
        }
        amount  = amount % s.length();
        if(amount < 0) {
            amount = amount * -1;
            return s.substring(amount) + s.substring(0, amount);
        } else if(amount > 0) {
            return s.substring(s.length() - amount) + s.substring(0, s.length() - amount);
        }
        return s;
    }
}
