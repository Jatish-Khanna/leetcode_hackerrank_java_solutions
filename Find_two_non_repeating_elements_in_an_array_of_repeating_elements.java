
public class Solution {

  public static void main(String[] args) {
    int[] arr = {2, 3, 7, 9, 11, 2, 3, 11};
    int xoredNumber = arr[0];
    for (int index  = 1; index < arr.length; index++) {
      xoredNumber = xoredNumber ^ arr[index];
    }
    
    int firstSetBit = xoredNumber & ~(xoredNumber - 1);
    int firstNumber = 0;
    int secondNumber = 0;
    for(int number : arr) {
      if((firstSetBit & number) == firstSetBit) {
        firstNumber = firstNumber ^ number;
      } else {
        secondNumber = secondNumber ^ number;
      }
    }
    System.out.println("FirstNumber: " + firstNumber);
    System.out.println("SecondNumber: " + secondNumber);

  }
}
