
public class Solution {
    
    // Major optimization with travering only odd numbers
    public int countPrimes(int n) {
      
        
        if (n < 3) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        int count = n / 2;
        int limit = (int)Math.ceil(Math.sqrt(n));
        // Loop only through odd numbers
        for(int i = 3; i < limit; i += 2){
            if (!notPrime[i]) {
                for (int j = i * i; j < n; j += 2 * i){
                    if(!notPrime[j]){
                        notPrime[j] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }


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
