

public class Solution {
public int findJudge(int N, int[][] trust) {
      int []inOutDegree = new int[N+1];
      for(int []ar : trust) {
          inOutDegree[ar[0]]--;
          inOutDegree[ar[1]]++;
      }
        
        for(int index = 1; index <= N; index++) {
            if(inOutDegree[index] == N - 1){
                return index;
            }
        }
        return -1;
    }
}
