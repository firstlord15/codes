class BSTNode {
    int key;
    BSTNode left;
    BSTNode right;

    BSTNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BST {
    BSTNode root;

    public void insert(int key) {
        root = insertHelper(root, key);
    }

    BSTNode insertHelper(BSTNode root, int key) {
        if (root == null) {
            return new BSTNode(key);
        }

        if (key < root.key) {
            root.left = insertHelper(root.left, key);
        } else if (key > root.key) {
            root.right = insertHelper(root.right, key);
        }

        return root;
    }

    public void visualize() {
        visualizeHelper(root, " ", true);
    }

    private void visualizeHelper(BSTNode node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }

        String nodeStr = Integer.toString(node.key);
        String line = prefix + (isLeft ? "├── " : "└── ");
        System.out.println(line + nodeStr);

        String childPrefix = prefix + (isLeft ? "│   " : "    ");
        visualizeHelper(node.left, childPrefix, true);
        visualizeHelper(node.right, childPrefix, false);
    }

    public void inOrderTraversal() {
        inOrderTraversalHelper(root);
        System.out.println();
    }

    private void inOrderTraversalHelper(BSTNode node) {
        if (node != null) {
            inOrderTraversalHelper(node.left);
            System.out.print(node.key + " ");
            inOrderTraversalHelper(node.right);
        }
    }

    void preOrderTraversal() {
        preOrderTraversalHelper(root);
        System.out.println();
    }

    void preOrderTraversalHelper(BSTNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderTraversalHelper(node.left);
            preOrderTraversalHelper(node.right);
        }
    }
}