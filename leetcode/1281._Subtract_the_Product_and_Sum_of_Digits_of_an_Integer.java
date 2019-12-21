

public class Solution {

      public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int number = n;
        while(number >= 1 ) {
            product *= number % 10;
            sum += number % 10;
            number /= 10;
        }
        return product - sum;
    }
}
