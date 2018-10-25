import java.util.Scanner;

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
	public static void preOrder(Node root) {

		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}
  	/*
	 * Node is defined as : class Node int data; Node left; Node right;
	 */
	 * Insert the node on conditions of BST i.e. left.data < root < right.data
	 * @param root The head or top of the tree
	 * @param data new node to be created with data
	 * @return root node to iterate over
	public static Node insert(Node root, int data) {
		if (root == null) {
			root = createNode(data);
			return root;
		}
		Node node = root;
		Node parent = null;
    
   // :Recurssive solution to insert node in BST    
//		if(root.data < data) {
//			insert(root.right, data);
//		} else if(root.data > data) {
//			insert(root.left, data);
//		}


		while (node != null) {
			parent = node;
			if (node.data < data) {
				node = node.right;
			} else if (node.data > data)
				node = node.left;
		}
		if (parent.data < data) {
			parent.right = createNode(data);
		} else if (parent.data > data) {
			parent.left = createNode(data);
		}

		return root;
	}
  
  /**
	 * Create new node with the data
	 * @param data node information 
	 * @return newly created node
	 */
	private static Node createNode(int data) {
		Node newNode = new Node(data);
		newNode.left = null;
		newNode.right = null;
		return newNode;
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
		preOrder(root);
	}
}
  

}
