import java.io.IOException;
import java.util.Scanner;

public class Solution  {
  private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int queries = scanner.nextInt();
        int stackFirstLength = 0;
        int stackSecondLength = 0;
        int limit = 0;

        for (int query = 0; query < queries; query++) {
            stackFirstLength = scanner.nextInt();
            stackSecondLength = scanner.nextInt();
            limit = scanner.nextInt();

            int[] stackFirst = new int[stackFirstLength]; //
            int[] stackSecond = new int[stackSecondLength];// = new
            int totalSum = 0;
            int indexFirst = 0;
            int secondLength = 0;
            int maxScore = 0;

            for (int index = 0; index < stackFirstLength; index++) {
                stackFirst[index] = scanner.nextInt();
            }

            for (int index = 0; index < stackSecondLength; index++) {
                stackSecond[index] = scanner.nextInt();
            }

            while (indexFirst < stackFirstLength && totalSum + stackFirst[indexFirst] <= limit) {
                totalSum += stackFirst[indexFirst];
                indexFirst++;
            }
            maxScore = indexFirst;

            while (secondLength < stackSecondLength) {
                totalSum += stackSecond[secondLength];
				secondLength++;
				
                while (totalSum > limit && indexFirst > 0) {
                    totalSum -= stackFirst[--indexFirst];
                }
                if (totalSum > limit) {
                    break;
                }
                // maxScore = Math.max(maxScore, indexFirst + secondLength);
				if(totalSum <= limit && indexFirst + secondLength > maxScore)
				  maxScore = indexFirst + secondLength;
                
            }
            System.out.println(maxScore);
        }
    }
}
