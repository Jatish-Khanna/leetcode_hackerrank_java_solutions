import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {
        //Create auxspace to store elements
        int[] dpSol;
        if (n <= 3)
            dpSol = new int[4];
        else
            dpSol = new int[n + 1];

        //Known solution
        dpSol[1] = 1;
        dpSol[2] = 2;
        dpSol[3] = 4;

        /*
         * Range to calculate number of ways 
         * to climb n stairs
         *  - This solution can be optimized to store last three values
         */
        for (int index = 4; index <= n; index++) {
            dpSol[index] = (int) ((dpSol[index - 1] + dpSol[index - 2] + dpSol[index - 3])%10000000007l);
        }

        //result is stored at last location (n stairs to climb)
        return dpSol[n];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
