class Solution {

	static int longestIncreasingSequenceLength = 0;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private static int longestConsecutive(Node node) {
		if (node == null)
			return 0;

		longestConsecutiveUtil(node, node.data, 0);
		return longestIncreasingSequenceLength;

	}

	private static void longestConsecutiveUtil(Node node, int expected, int currentLength) {
		if (node == null) {
			return;
		}

		if (node.data == expected) {
			currentLength++;
		} else {
			currentLength = 1;
		}

		longestIncreasingSequenceLength = Math.max(longestIncreasingSequenceLength, currentLength);

		longestConsecutiveUtil(node.left, node.data + 1, currentLength);
		longestConsecutiveUtil(node.right, node.data + 1, currentLength);
	}

	// Driver code to test above methods
	public static void main(String[] args) {
		Node root = new Node(6);
		root.right = new Node(9);
		root.right.left = new Node(7);
		root.right.right = new Node(10);
		root.right.right.right = new Node(11);

		System.out.println(longestConsecutive(root));

	}
}
