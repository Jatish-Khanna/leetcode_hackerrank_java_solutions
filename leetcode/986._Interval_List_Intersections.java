

public class Solution {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int aIndex = 0;
        int bIndex = 0;
        
        int start;
        int end;
        
        List<int[]> result = new ArrayList<>();
        
        while(aIndex < A.length && bIndex < B.length) {
            if(isBefore(A[aIndex],B[bIndex])) {
                aIndex++;
            } else if(isBefore(B[bIndex], A[aIndex])) {
                bIndex++;
            } else {
                start = Math.max(A[aIndex][0], B[bIndex][0]);
                end = Math.min(A[aIndex][1], B[bIndex][1]);
                
                result.add(new int[]{start, end});
                
                if(A[aIndex][1] < B[bIndex][1]) {
                    aIndex++;
                } else if(A[aIndex][1] > B[bIndex][1]) {
                    bIndex++;
                } else {
                    aIndex++;
                    bIndex++;
                }
            }
        }
        
        return result.toArray(new int[result.size()][2]);
    }
    
    private boolean isBefore(int []first, int []second) {
        return first[1] < second[0];
    }
}
