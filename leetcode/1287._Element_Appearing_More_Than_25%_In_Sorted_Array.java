

public class Solution {

public int findSpecialInteger(int[] arr) {
        int appearance = arr.length / 4;
        int current;
        for(int index = 0; index < 4; index++) {
            current = index * appearance;
            int first = findFirst(arr, arr[current], 0, current);
            int last = findLast(arr, arr[current], current, arr.length);
            if(last - first + 1 > appearance) {
                return arr[current];
            }
        }
        return -1;
    }
    public int findFirst(int []arr, int element, int start, int end) {
        
        if(start <= end) {
          int mid = start + (end - start) / 2;
          if(arr[mid] < element) {
              return findFirst(arr, element, mid + 1, end);
          } else if( mid == 0  || (arr[mid] > arr[mid - 1]) && arr[mid] == element){
              return mid;
          } else {
             return findFirst(arr, element, start, mid - 1);
          }
        }
        return -1;
    }
    public int findLast(int []arr, int element, int start, int end) {
        
        if(start <= end) {
          int mid = start + (end - start) / 2;
          if(arr[mid] > element) {
              return findLast(arr, element, start, mid - 1);
          } else if( mid == arr.length - 1  || (arr[mid] < arr[mid + 1]) && arr[mid] == element){
              return mid;
          } else {
             return findLast(arr, element, mid + 1, end);
          }
        }
        return -1;
    }
}
