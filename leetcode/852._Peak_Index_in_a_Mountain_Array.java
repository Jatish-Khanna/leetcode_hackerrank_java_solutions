

public class Solution {
    
    // another way - no optimizations
    public int peakIndexInMountainArray(int[] A) {
        return mountainIndex(A, 0, A.length - 1);
    }
    
    public int mountainIndex(int []A, int start, int end) {
       int mid = -1;
        while(start <= end) {
        mid = start + (end - start) / 2;
            // Found the mountain
        if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1] ){
                return mid;
        } else if(A[mid] > A[mid + 1]) {
            // decreasing order at mid- mountain point to the left
            end = mid;
        } else {
            // increasing order - mountain point to the right
             start = mid;
        }
        }
        return mid;
    }

    

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
