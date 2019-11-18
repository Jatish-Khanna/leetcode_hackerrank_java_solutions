
public class Solution {
    public static void main(String[] args) {
    int[] arr = {3, 4, 2, 1, 5};
    int lowerBoundary = 3;

    long totalSubarrays = countSubarrays(arr.length);
    int length = 0;
    long subarraysWithLowerValue = 0;
    for (int index = 0; index < arr.length; index++) {
      length = 0;
      for (; index < arr.length && arr[index] <= lowerBoundary; index++) {
        length++;
      }
      subarraysWithLowerValue += countSubarrays(length);
    }

    System.out.println(totalSubarrays - subarraysWithLowerValue);
  }

  private static long countSubarrays(long count) {

    return count * (count + 1) >> 1;
  }
}
