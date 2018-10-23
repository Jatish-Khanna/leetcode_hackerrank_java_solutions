import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;


class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Solution {
	/*
	 * 
	 * class Node int data; Node left; Node right;
	 */
	private static class NodeMap {
		Node node;
		int level;

		public NodeMap(Node node, int level) {
			super();
			this.node = node;
			this.level = level;
		}
 }

	public static void topView(Node root) {
		if (root == null)
			return;
		Queue<NodeMap> visited = new LinkedList<>();
		Map<Integer, Node> topTreeView = new TreeMap<>();
		visited.add(new NodeMap(root, 0));
		NodeMap current;
		while (!visited.isEmpty()) {
			current = visited.poll();
			if (!topTreeView.containsKey(current.level)) {
				topTreeView.put(current.level, current.node);
			}
			if (current.node.left != null) {
				visited.add(new NodeMap(current.node.left, current.level - 1));
			}
			if (current.node.right != null) {
				visited.add(new NodeMap(current.node.right, current.level + 1));
			}
		}
		topTreeView.entrySet().stream().forEach(element -> System.out.print(element.getValue().data + " "));
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		topView(root);
	}

}
