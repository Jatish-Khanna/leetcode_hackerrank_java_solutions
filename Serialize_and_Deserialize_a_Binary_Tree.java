import java.util.ArrayList;

class Solution {

	static ArrayList<Integer> serialization = new ArrayList<>();
	static final int MARKER = -1;
	static int index = 0;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private static void printInorderTraversal(Node node) {
		if (node == null)
			return;

		printInorderTraversal(node.left);
		System.out.print(node.data + "  ");
		printInorderTraversal(node.right);
	}

	private static void serializeTree(Node node) {
		if (node == null) {
			serialization.add(MARKER);
			return;
		}
		serialization.add(node.data);
		serializeTree(node.left);
		serializeTree(node.right);

	}

	private static Node deSerialize() {
		if (serialization.size() <= index || serialization.get(index) == MARKER)
			return null;

		Node tree = new Node(serialization.get(index));
		index++;
		tree.left = deSerialize();
		index++;
		tree.right = deSerialize();

		return tree;
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {

		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		serializeTree(root);
		serialization.stream().forEach(element -> System.out.print(element + " "));

		Node deSerializedTree = null;

		deSerializedTree = deSerialize();
		System.out.println();
		printInorderTraversal(deSerializedTree);
	}
}
