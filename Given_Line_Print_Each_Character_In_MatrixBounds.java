import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

  public static void main(String[] args) throws FileNotFoundException {
    java.io.File file = new java.io.File("2DArray.txt");

    int totalRow = 6;
    int totalColumn = 7;
    char[][] myArray = new char[totalRow][totalColumn];
    Scanner scanner = new Scanner(file);
    file = new java.io.File("2DArray.txt");
    int rowIndex = 0;
    
    
    while (scanner.hasNextLine()) {
      char[] chars = scanner.nextLine().toCharArray();

      for (int charIndex = 0; rowIndex < totalRow && charIndex < chars.length; rowIndex++, charIndex =
          charIndex + totalColumn) {
        System.arraycopy(chars, charIndex, myArray[rowIndex], 0,
            Math.min(totalColumn, chars.length - charIndex));
      }
    }

    for (char[] ar : myArray) {
      System.out.println(Arrays.toString(ar));
    }
    scanner.close();
  }
}
