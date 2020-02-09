

public class Solution {


    public int[] kWeakestRows(int[][] mat, int k) {
        
        // Use max queue to sort and remove the elements not required.
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((e1, e2) -> {
            
          if(e1[1] == e2[1]) {
              return e2[0] - e1[0];
          }
            return e2[1] - e1[1];
        });
        
        int sum;
        for(int index = 0; index < mat.length; index++) {
            sum = 0;
            for(int element : mat[index]) {
                sum += element;
            }
            pq.offer(new int[]{index, sum});
            if(pq.size() > k) {
                pq.remove();
            }
        }
        int []result = new int[k];
        int ri = k - 1;
        while(!pq.isEmpty()) {
            result[ri--] = pq.remove()[0];
        }
        return result;
    }
}
