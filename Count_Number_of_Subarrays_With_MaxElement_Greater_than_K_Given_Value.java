
public class Solution {
  public static void main(String[] args) {
    int[] arr = {3, 4, 2, 1, 5};
    int lowerBoundary = 2;

    long totalSubarrays = countSubarrays(arr.length);
    int length = 0;
    int subIndex = 0;
    long subarraysWithLowerValue = 0;
    for (int index = 0; index < arr.length; index++) {
      for (subIndex = index; subIndex < arr.length && arr[subIndex] <= lowerBoundary; subIndex++) {
        length++;
      }
      index = subIndex;
      subarraysWithLowerValue += countSubarrays(length);
      length = 0;
    }

    System.out.println(totalSubarrays - subarraysWithLowerValue);
  }

  private static long countSubarrays(long count) {

    return count * (count + 1) >> 1;
  }
}
