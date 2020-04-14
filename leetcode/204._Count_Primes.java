
public class Solution {

    public int countPrimes(int n) {
      boolean []ar = new boolean[n];
      //Arrays.fill(ar, true);
        int limit = (int)Math.ceil(Math.sqrt(n));
        for(int index = 2; index < limit; index++) {
            if(!ar[index]) {
                for(int j = index * index; j < n; j += index) {
                    ar[j] = true;
                }
            }
        }
        
        int count = 0;
        for(int index = 2; index < n; index++) {
            if(!ar[index]) {
                count++;
            }
        }
        return count;
    }
}
