import java.util.Scanner;

public class Solution {

  public static void main(String []args) {
  
    Scanner in = new Scanner(System.in);
    int number = in.nextInt();
    
    if(checkIsPowerOfTwo(number)){
      System.out.println("The number is power of two.");
    } else{
      System.out.println("The number is not power of two.");
    }
    in.close();
  }
  
  public static boolean checkIsPowerOfTwo(int number){
    return (number > 0 ) && ((number & number - 1 )== 0);
  }
}
