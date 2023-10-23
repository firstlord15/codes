class AVLTree {
    AVLNode root = null;

    public AVLTree() {
    }

    public void insert(int key) {
        this.root = this.insertHelper(this.root, key);
    }

    private AVLNode insertHelper(AVLNode root, int key) {
        if (root == null) {
            return new AVLNode(key);
        } else {
            if (key < root.key) {
                root.left = this.insertHelper(root.left, key);
            } else if (key > root.key) {
                root.right = this.insertHelper(root.right, key);
            }

            root.height = 1 + Math.max(this.getHeight(root.left), this.getHeight(root.right));
            int balanceFactor = this.getBalance(root);
            if (balanceFactor > 1) {
                if (key < root.left.key) {
                    return this.rightRotate(root);
                } else {
                    root.left = this.leftRotate(root.left);
                    return this.rightRotate(root);
                }
            } else if (balanceFactor < -1) {
                if (key > root.right.key) {
                    return this.leftRotate(root);
                } else {
                    root.right = this.rightRotate(root.right);
                    return this.leftRotate(root);
                }
            } else {
                return root;
            }
        }
    }

    public AVLNode delete(AVLNode root, int key) {
        if (root == null) {
            return root;
        } else {
            if (key < root.key) {
                root.left = this.delete(root.left, key);
            } else if (key > root.key) {
                root.right = this.delete(root.right, key);
            } else {
                AVLNode temp;
                if (root.left == null) {
                    temp = root.right;
                    root = null;
                    return temp;
                }

                if (root.right == null) {
                    temp = root.left;
                    root = null;
                    return temp;
                }

                temp = this.getMinValueNode(root.right);
                root.key = temp.key;
                root.right = this.delete(root.right, temp.key);
            }

            if (root == null) {
                return root;
            } else {
                root.height = 1 + Math.max(this.getHeight(root.left), this.getHeight(root.right));
                int balanceFactor = this.getBalance(root);
                if (balanceFactor > 1) {
                    if (this.getBalance(root.left) >= 0) {
                        return this.rightRotate(root);
                    } else {
                        root.left = this.leftRotate(root.left);
                        return this.rightRotate(root);
                    }
                } else if (balanceFactor < -1) {
                    if (this.getBalance(root.right) <= 0) {
                        return this.leftRotate(root);
                    } else {
                        root.right = this.rightRotate(root.right);
                        return this.leftRotate(root);
                    }
                } else {
                    return root;
                }
            }
        }
    }

    public int getHeight(AVLNode root) {
        return root == null ? 0 : root.height;
    }

    public int getBalance(AVLNode root) {
        return root == null ? 0 : this.getHeight(root.left) - this.getHeight(root.right);
    }

    public AVLNode leftRotate(AVLNode z) {
        AVLNode y = z.right;
        AVLNode T2 = y.left;
        y.left = z;
        z.right = T2;
        z.height = 1 + Math.max(this.getHeight(z.left), this.getHeight(z.right));
        y.height = 1 + Math.max(this.getHeight(y.left), this.getHeight(y.right));
        return y;
    }

    public AVLNode rightRotate(AVLNode z) {
        AVLNode y = z.left;
        AVLNode T3 = y.right;
        y.right = z;
        z.left = T3;
        z.height = 1 + Math.max(this.getHeight(z.left), this.getHeight(z.right));
        y.height = 1 + Math.max(this.getHeight(y.left), this.getHeight(y.right));
        return y;
    }

    public AVLNode getMinValueNode(AVLNode root) {
        return root != null && root.left != null ? this.getMinValueNode(root.left) : root;
    }

    public void visualize() {
        this._visualize_helper(this.root, "", true);
    }

    private void _visualize_helper(AVLNode node, String prefix, boolean isLeft) {
        if (node != null) {
            String nodeStr = Integer.toString(node.key);
            String line = prefix + (isLeft ? "├── " : "└── ");
            System.out.println(line + nodeStr);
            String childPrefix = prefix + (isLeft ? "│   " : "    ");
            this._visualize_helper(node.left, childPrefix, true);
            this._visualize_helper(node.right, childPrefix, false);
        }
    }

    public void inOrderTraversal() {
        this.inOrderTraversalHelper(this.root);
        System.out.println();
    }

    private void inOrderTraversalHelper(AVLNode node) {
        if (node != null) {
            this.inOrderTraversalHelper(node.left);
            System.out.print(node.key + " ");
            this.inOrderTraversalHelper(node.right);
        }

    }
}
