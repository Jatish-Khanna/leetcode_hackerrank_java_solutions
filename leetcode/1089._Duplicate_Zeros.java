

public class Solution {

      public void duplicateZeros(int[] arr) {

        if(arr == null || arr.length == 0) {return;}
        
        int []result = Arrays.copyOf(arr, arr.length);
        int count = 0;
        int index  = 0;
       while(count < arr.length) {
           
           arr[count++] = result[index];
           
           if(result[index] == 0 && count < arr.length) {
                arr[count++] = 0;
            }
           index++;
        }
    }
}
