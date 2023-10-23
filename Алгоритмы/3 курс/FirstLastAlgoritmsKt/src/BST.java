class BST {
    BSTNode root;

    BST() {
    }

    public void insert(int key) {
        this.root = this.insertHelper(this.root, key);
    }

    BSTNode insertHelper(BSTNode root, int key) {
        if (root == null) {
            return new BSTNode(key);
        } else {
            if (key < root.key) {
                root.left = this.insertHelper(root.left, key);
            } else if (key > root.key) {
                root.right = this.insertHelper(root.right, key);
            }

            return root;
        }
    }

    public void visualize() {
        this.visualizeHelper(this.root, " ", true);
    }

    private void visualizeHelper(BSTNode node, String prefix, boolean isLeft) {
        if (node != null) {
            String nodeStr = Integer.toString(node.key);
            String line = prefix + (isLeft ? "├── " : "└── ");
            System.out.println(line + nodeStr);
            String childPrefix = prefix + (isLeft ? "│   " : "    ");
            this.visualizeHelper(node.left, childPrefix, true);
            this.visualizeHelper(node.right, childPrefix, false);
        }
    }

    public void inOrderTraversal() {
        this.inOrderTraversalHelper(this.root);
        System.out.println();
    }

    private void inOrderTraversalHelper(BSTNode node) {
        if (node != null) {
            this.inOrderTraversalHelper(node.left);
            System.out.print(node.key + " ");
            this.inOrderTraversalHelper(node.right);
        }

    }

    void preOrderTraversal() {
        this.preOrderTraversalHelper(this.root);
        System.out.println();
    }

    void preOrderTraversalHelper(BSTNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            this.preOrderTraversalHelper(node.left);
            this.preOrderTraversalHelper(node.right);
        }

    }
}