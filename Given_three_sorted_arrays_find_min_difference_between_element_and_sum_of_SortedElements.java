
import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    int[] arr = {4, 2, 1, 6, 7, 8, 1, 2};
    int[] arr2 = {4, 2, 1, 6, 7, 8, 1, 2};
    int[] arr3 = {4, 2, 1, 6, 7, 8, 1, 2};
    int element = 21;
    int closest = Integer.MAX_VALUE;
    int diff = -1;

    Arrays.sort(arr);
    Arrays.sort(arr2);
    Arrays.sort(arr3);

    int first = 0;
    int second = 0;
    int third = arr3.length - 1;


    while (first < arr.length && second < arr2.length && third >= 0) {
      diff = element - arr[first] - arr[second] - arr[third];


      if (diff > 0) {
        closest = Math.min(diff, closest);
        if (isSmaller(arr, first, second)) {
          first++;
        } else {
          second++;
        }
      } else {
        closest = Math.min(Math.abs(diff), closest);
        third--;
      }
    }
    System.out.println(closest);
  }

  private static boolean isSmaller(int[] arr, int e1, int e2) {

    return arr[e1] < arr[e2];
  }
}
