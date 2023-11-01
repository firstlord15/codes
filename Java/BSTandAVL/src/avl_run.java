public class avl_run {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        // Insert nodes into the BST
        int[] anArrayNodes = {
                17, 6, 5, 20, 19, 18, 11, 14, 12, 13, 2, 4, 10
        };

        for (int anArrayNode : anArrayNodes) {
            avlTree.insert(anArrayNode);
        }

        // Visualize the BST
        avlTree.visualize();

        // In-order traversal of BST
        System.out.print("In-order Traversal: ");
        avlTree.inOrderTraversal();
    }
}
