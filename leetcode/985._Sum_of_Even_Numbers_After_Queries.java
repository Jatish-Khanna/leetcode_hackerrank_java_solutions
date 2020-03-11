

public class Solution {


    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int []result = new int[queries.length];
        int sum = 0;
        for(int num : A) {
            if(num % 2 == 0) {
                sum += num;
            }
        }
        
        int index = 0;
        int old;
        int current = 0;
        for(int[] query : queries) {
            old = A[query[1]];
            current = old + query[0];
            if(old % 2 == 0) {
                sum -= old;
            } 
            
            if(current % 2 == 0) {
                sum += current;
            }
            A[query[1]] = current;
            result[index++] = sum;
            //index++;
        }
        return result;
    }
}
