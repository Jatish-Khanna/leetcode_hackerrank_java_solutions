/* Write a function that takes as input two integers A and B

Output: return 1 if A>B, 0 otherwise

Function should not use
-	Logical operator/statement/instruction
-	Comparison operator/statement/instruction
-	Any conditional operator/statement/instruction
-	Any looping construct
-	Any function from built-in library
*/


public class Solution {
  public static void main(String[] args) {
    System.out.println(findMax(2, 5));
    System.out.println(findMax(0, 0));
    System.out.println(findMax(1, 0));
    System.out.println(findMax(45, 56));
    System.out.println(findMax(-5, 3));
  }

  private static int findMax(int num1, int num2) {
    return (num2 - num1) >>> 31;
  }
}
