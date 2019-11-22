
public class Solution {

  public static void main(String[] args) {
    ArrayDeque<Integer> s = new ArrayDeque<>();
    s.push(30);
    s.push(-5);
    s.push(18);
    s.push(14);
    s.push(-3);

    System.out.println("Stack elements before sorting: ");
    printStack(s);

    sortStack(s);

    System.out.println(" \n\nStack elements after sorting:");
    printStack(s);


  }

  private static void sortStack(ArrayDeque<Integer> s) {
    if (!s.isEmpty()) {
      int element = s.pop();
      sortStack(s);
      sortStackUtil(s, element);
    }
  }

  private static void sortStackUtil(ArrayDeque<Integer> s, int element) {
    if (s.isEmpty() || s.peek() <= element) {
      s.push(element);
      return;
    }
    int top = s.pop();
    sortStackUtil(s, element);
    s.push(top);
  }

  private static void printStack(ArrayDeque<Integer> s) {
    for (Integer integer : s) {
      System.out.println(integer);
    }
  }
}
