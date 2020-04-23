/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int n = dimension.get(0);
        int m = dimension.get(1);
        int found = m + 1;
        int row = 0;
        int col = m - 1;
        while(row < n && col >= 0 && found > 0) {
            found = Math.min(found, binarySearch(0, col, row, binaryMatrix));
            col = Math.min(found, col);
            row++;
        }
        return found == m + 1 ? -1 : found;
    }
    
    private int binarySearch(int start, int end, int row, BinaryMatrix bm) {
        int mid;
        int val = bm.get(row, end);
        if(val == 0) {
            return Integer.MAX_VALUE;
        }
        int old = end;
        while(start <= end) {
            mid = start + (end - start) / 2;
            val = bm.get(row, mid);
            if((mid == 0 || bm.get(row, mid - 1) == 0) && val == 1) {
                return mid;
            } else if(val == 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
