import java.util.ArrayList;

public class Solution {
  public static void main(String[] args) {
    int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
    int A1[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};

    ArrayList<Double> distanceList = new ArrayList<>();

    for (int index = 0; index < A.length; index++) {
      for (int index2 = 0; index2 < A1.length; index2++) {
        distanceList.add(distance(A[index], A1[index2]));
      }
    }
    
    distanceList.stream().sorted().limit(10).forEach(System.out::println);

  }

  private static double distance(int one, int two) {
    return Math.sqrt(Math.pow(one, 2) + Math.pow(two, 2));
  }
}
