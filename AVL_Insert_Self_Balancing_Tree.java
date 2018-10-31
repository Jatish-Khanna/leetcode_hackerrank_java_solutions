	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

    static Node insert(Node root, int val) {
        Node newRoot = root;
        if (root == null) {
            newRoot = new Node();
            newRoot.val = val;
            return newRoot;
        }
        if (root.val < val) {
            root.right = insert(root.right, val);
        } else if (root.val >= val) {
            root.left = insert(root.left, val);
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int balanceFactor = leftHeight - rightHeight;

        // Left left case
        if (balanceFactor > 1) {
            if (getHeight(root.left.left) >= getHeight(root.left.right)) {
                root = rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        } else if (balanceFactor < -1) {
            if (getHeight(root.right.right) >= getHeight(root.right.left)) {
                root = leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        } else {
            root.ht = setHeight(root);
        }
        return root;
    }


    private static Node leftRotate(Node root) {
        Node oldRoot = root;
        Node newRoot = oldRoot.right;
        Node oldLeft = newRoot.left;

        newRoot.left = oldRoot;
        oldRoot.right = oldLeft;

        oldRoot.ht = setHeight(oldRoot);
        newRoot.ht = setHeight(newRoot);

        return newRoot;
    }

    private static Node rightRotate(Node root) {
        Node oldRoot = root;
        Node newRoot = oldRoot.left;
        Node oldRight = newRoot.right;

        newRoot.right = oldRoot;
        oldRoot.left = oldRight;

        oldRoot.ht = setHeight(oldRoot);
        newRoot.ht = setHeight(newRoot);

        return newRoot;
    }

    private static int setHeight(Node node) {
        if (node == null)
            return -1;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private static int getHeight(Node node) {
        if (node == null)
            return -1;
        return node.ht;
    }




