

public class Solution {

     public int fib(int N) {
        int a = 0;
        if(N == 0) { return a; }
        int b = 1;
        int c = 1;
        for(int num = 1; num < N; num++) {
            c = a + b;   
            a = b;
            b = c;
            
        }
        return c;
    }
}
