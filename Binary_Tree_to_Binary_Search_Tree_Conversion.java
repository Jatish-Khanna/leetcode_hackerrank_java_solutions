import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

class Solution {


	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	private static Integer MARKER = null;
	private static int index = 0;

	private static void binaryTreeToBST(Node node) {
		if (node == null) {
			return;
		}
		ArrayList<Integer> preorderOfTree = new ArrayList<>();
		getPreOrderTraversal(node, preorderOfTree);
		Collections.sort(preorderOfTree, new Comparator<Integer>() {

			public int compare(Integer number1, Integer number2) {
				if (number1 == null || number2 == null) {
					return 0;
				} else {
					return number1 - number2;
				}
			}
		});
		index = 0;
		createBinaryTreeOfPreOrderTraversal(node, preorderOfTree);
	}

	private static void getPreOrderTraversal(Node node, ArrayList<Integer> preorderOfTree) {
		if (node == null) {
//			preorderOfTree.add(MARKER);
			return;
		}

		getPreOrderTraversal(node.left, preorderOfTree);
		preorderOfTree.add(node.data);
		getPreOrderTraversal(node.right, preorderOfTree);
	}

	private static void createBinaryTreeOfPreOrderTraversal(Node node, ArrayList<Integer> preorderOfTree) {
		if (preorderOfTree.size() <= index || preorderOfTree.get(index) == MARKER) {
			index++;
			return;
		} else if(node == null) {
			return;
		}
		createBinaryTreeOfPreOrderTraversal(node.left, preorderOfTree);
		node.data = preorderOfTree.get(index);
		index++;
		createBinaryTreeOfPreOrderTraversal(node.right, preorderOfTree);
	}

	private static void printInorder(Node node) {
		if (node == null) {
			return;
		}

		printInorder(node.left);
		System.out.println(node.data);
		printInorder(node.right);
	}

	/* Driver function to test above functions */
	public static void main(String[] args) {
		Node root = null;

		/*
		 * Constructing tree given in the above figure 10 / \ 30 15 / \ 20 5
		 */
		root = new Node(10);
		root.left = new Node(30);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.right.right = new Node(5);

		// convert Binary Tree to BST
		binaryTreeToBST(root);

		System.out.println("Following is Inorder Traversal of the converted BST: ");
		printInorder(root);

	}
}
