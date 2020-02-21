

public class Solution {
    public int[] replaceElements(int[] arr) {
        int temp = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        int current;
        for(int index = arr.length - 2; index >= 0; index--) {
            current = arr[index];
            arr[index] = temp;
            if(temp < current) {
              temp = current;
            } 
        }
        return arr;
    }
}
