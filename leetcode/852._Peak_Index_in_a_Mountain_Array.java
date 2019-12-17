

public class Solution {

    public int peakIndexInMountainArray(int[] A) {
        return mountainIndex(A, 0, A.length - 1);
    }
    
    public int mountainIndex(int []A, int start, int end) {
       int mid = -1;
        while(start < end) {
        mid = start + (end - start) / 2;
        if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1] ){
                start = mid;
        }
        else if(A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                end = mid;
        } else {
            break;
        }
        }
        return mid;
    }
}
