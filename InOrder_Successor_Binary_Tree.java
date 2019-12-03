

public class Solution {

  static class Node {
  
      int data;
    Node left, right;

    Node(int data) {
      this.data = data;
    }
  }

  static Node inorderSuccessor(Node root, int data) {

    Node inorderSuccessor = null;

    if (root == null) {
      return inorderSuccessor;
    }
    while (root != null) {
      if (root.data > data) {
        inorderSuccessor = root;
        root = root.left;
      } else if (root.data < data) {
        root = root.right;
      } else {
        if (root.right != null) {
          return findMinimum(root.right);
        }
        return inorderSuccessor;
      }
    }
    return null;
  }

  private static Node findMinimum(Node right) {
    while (right.left != null) {
      right = right.left;
    }
    return right;
  }

  public static void main(String[] args) {
    int[] ar = new Random().ints().limit((int) (Math.random() * 1000)).toArray();
    Arrays.sort(ar);
    // Arrays.stream(ar).forEach(element -> System.out.print(" " + element));
    Node root = buildTree(ar, 0, ar.length - 1);
    int indexToSearch = (int) (Math.random() * ar.length);
    int indexToSearchPlusOne = indexToSearch + 1;
    System.out.println(ar[indexToSearch] + " " + ar[indexToSearchPlusOne]);
    System.out.println("\n"
        + Optional.ofNullable(inorderSuccessor(root, ar[indexToSearch])).orElse(new Node(-1)).data);

  }

  private static Node buildTree(int[] ar, int i, int j) {

    if (i > j) {
      return null;
    }

    int mid = i + (j - i) / 2;
    Node root = new Node(ar[mid]);
    root.left = buildTree(ar, i, mid - 1);
    root.right = buildTree(ar, mid + 1, j);

    return root;
  }
}
