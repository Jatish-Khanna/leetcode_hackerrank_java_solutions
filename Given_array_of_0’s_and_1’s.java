

public class Solution {
  public static void main(String[] args) {
    int[] arr = {1};
    System.out.println(firstOccurrance(arr));


  }

  static int firstOccurrance(int[] sortedBins) {
    int lower = 0;
    int upper = sortedBins.length - 1;

    if (sortedBins == null || sortedBins.length == 0) {
      return -1;
    }
    if (sortedBins[0] == 1) {
      return 0;
    }

    while (lower <= upper) {
      int middle = lower + (upper - lower) / 2;
      if (sortedBins[middle] == 0) {
        lower = middle + 1;
      } else if (sortedBins[middle] == 1 && sortedBins[middle - 1] == 0) {
        return middle;
      } else {
        upper = middle - 1;
      }

    }
    return -1;
  }
}
