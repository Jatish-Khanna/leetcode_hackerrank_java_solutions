

public class Solution {


    public boolean isHappy(int n) {
       int num = n;
        HashSet<Integer> seen = new HashSet<>();
        while(num != 1 && !seen.contains(num)) {
            seen.add(num);
            num = squares(num);
            //System.out.println(num);
        }
        return num == 1;
    }
    
    public int squares(int num) {
        int sum = 0;
       while(num > 0) {
           sum += (int)Math.pow((num %10),2);
           num /= 10;
       }   
        return sum;
    }
}
