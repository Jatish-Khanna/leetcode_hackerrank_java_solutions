

public class Solution {

  public int sumOfDigits(int[] A) {
    int min = Integer.MAX_VALUE;
    for(int element : A) {
      if(min > element) {
        min = element;
      } 
    }
    return getDigitsSum(min) % 2 == 0 ? 1 : 0;
  }
  
  public int getDigitsSum(int number) {
    
    int sum = 0;
    while(number > 0) {
      sum += number % 10;
      number /= 10;
    }
    return sum;
  }
}
