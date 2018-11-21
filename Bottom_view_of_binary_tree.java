import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map.Entry;

class Solution {


  
  public static void main(String []args) {
	Node root;
	root = new Node(20);
	root.left = new Node(8);
	root.right = new Node(22);
	root.left.left = new Node(5);
	root.left.right = new Node(3);
	
	root.right.left = new Node(4);
	root.right.right = new Node(25);
	
	root.left.right.left = new Node(10);
	root.left.right.right = new Node(14);
	
	bottomViewOfTree(root);
	
  }

  private static void bottomViewOfTree(Node root) {
  // No node is present in tree
  if(root == null)
	  return;
	// Dictionary to store sorted nodes based on bottom view
	Map<Integer, Node> dictionary = new TreeMap<>();
  // To process the tree in level-order traversal mode
	Queue<Node> queue = new LinkedList<>();
	
	// Start with root node
	queue.offer(root);
  // Iterate until all the nodes have been processed
	while(!queue.isEmpty()) {
    // Get the node to process
		Node node = queue.poll();
    // Modify/or add the node seen at same horizontal level
		dictionary.put(node.level, node);
		
    // Add the left node to the queue
		if(node.left != null){
      // update the level of left node
			node.left.level = node.level - 1;
			queue.offer(node.left);
		}
		
		
		if(node.right != null){
			node.right.level = node.level + 1;
			queue.offer(node.right);
		}
	}
	
  // Print all the nodes in sorted order based on the level
	for(Entry<Integer, Node> entry : dictionary.entrySet()){
		System.out.println(entry.getValue().data);
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
