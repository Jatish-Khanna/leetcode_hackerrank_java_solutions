class Test {

  static class Result {
     int largerIndex;
    int smallerIndex;
    int diff;
  }

  static Result diff(int arr[], int n) {

    Result result = new Result();
    int maxdiff = -1;
    int lowestAtTop = arr[arr.length - 1];
    int lowestIndex = arr.length - 1;
    result.smallerIndex = arr.length - 1;
    result.largerIndex = -1;

    for (int index = arr.length - 2; index >= 0; index--) {
      if (arr[index] >= lowestAtTop) {
        if (maxdiff < arr[index] - lowestAtTop) {
          result.largerIndex = index;
          result.smallerIndex = lowestIndex;
          maxdiff = arr[index] - lowestAtTop;
        }
      } else {
        lowestAtTop = arr[index];
        lowestIndex = index;
      }
    }
    result.diff = maxdiff;
    return result;

  }

  public static void main(String[] args) {
    int arr[] = {1, 2};
    int n = arr.length;
    Result ans = Test.diff(arr, n);
    System.out.println("Largest Element Index: " + ans.largerIndex);
    System.out.println("Smallest element Index: " + ans.smallerIndex);
    System.out.println("Max difference: " + ans.diff);
  }
}
