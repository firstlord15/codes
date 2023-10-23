class AVLNode {
    int key;
    AVLNode left;
    AVLNode right;
    int height;

    public AVLNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}