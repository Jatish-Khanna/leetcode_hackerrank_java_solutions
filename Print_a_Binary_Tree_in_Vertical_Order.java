import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

class Solution {


	public static void main(String[] args) {
		Node root;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.left.right = new Node(8);
		
		root.right.right = new Node(7);
		root.right.right.right = new Node(9);

//	root.left.right.left = new Node(10);
//	root.left.right.right = new Node(14);

		bottomViewOfTree(root);

	}

	private static void bottomViewOfTree(Node root) {
		if (root == null)
			return;

		Map<Integer, ArrayList<Node>> dictionary = new TreeMap<>();
		Queue<Node> queue = new LinkedList<>();

		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			ArrayList<Node> list = dictionary.getOrDefault(node.level, new ArrayList<>());
			list.add(node);
			dictionary.put(node.level, list);

			if (node.left != null) {
				node.left.level = node.level - 1;
				queue.offer(node.left);
			}

			if (node.right != null) {
				node.right.level = node.level + 1;
				queue.offer(node.right);
			}
		}

		for (Entry<Integer, ArrayList<Node>> entry : dictionary.entrySet()) {
			for (Node printNode : entry.getValue()) {
				System.out.print(printNode.data + " ");
			}
			System.out.println();
		}

	}
}

class Node {

	int data;
	int level;
	Node left;
	Node right;

	Node(int data) {
		super();
		this.data = data;
	}

}
