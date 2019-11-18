import java.util.Arrays;


public class Solution {
  public static void main(String[] args) {
    int[] arr = {4, 2, 1, 6, 7, 8, 1, 2};
    for (int index = 0; index < arr.length - 2; index = index + 2) {
      swapForward(arr, index, index + 1);
      swapReverse(arr, index + 1, index + 2);
    }
    Arrays.stream(arr).forEach(System.out::println);
  }

  private static void swapReverse(int[] arr, int index, int next) {

    if (arr[index] < arr[next]) {
      swap(arr, index, next);
    }
  }

  private static void swapForward(int[] arr, int index, int next) {
    if (arr[index] > arr[next]) {
      swap(arr, index, next);
    }
  }

  private static void swap(int[] arr, int index, int next) {

    int temp = arr[index];
    arr[index] = arr[next];
    arr[next] = temp;
  }
}
