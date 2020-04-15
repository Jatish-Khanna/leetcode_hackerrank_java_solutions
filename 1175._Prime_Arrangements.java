

public class Solution {

    
    private static final long mod = (int)(1e9 + 7);
    private long []fact;
    
    public int numPrimeArrangements(int n) {
        int []ar = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        
        int pos = Arrays.binarySearch(ar, n);
        if(pos >= 0) {
            pos++;
        } else {
            pos = (pos*-1) - 1;
        }
        
        fact = new long[Math.max(n-pos, pos) + 1];
        factorial();
        return (int)((fact[n-pos] * fact[pos]) % mod) ;
    }
    
    private void factorial() {
        fact[0] = 1;
        fact[1] = 1;
        for(int index = 2; index < fact.length; index++) {
            fact[index] = (fact[index - 1] * index) % mod;
        }
    }
   
}
