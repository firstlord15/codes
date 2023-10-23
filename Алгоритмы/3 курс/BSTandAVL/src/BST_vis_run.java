public class BST_vis_run {
    public static void main(String[] args) {
        BST bst = new BST();

        // Insert nodes into the BST
        int[] anArrayNodes = {
                17, 6, 5, 20, 19, 18, 11, 14, 12, 13, 2, 4, 10
        };

        for (int i = 0; i < anArrayNodes.length; i++) {
            bst.insert(anArrayNodes[i]);
        }

        // Visualize the BST
        bst.visualize();

        // In-order traversal of BST
        System.out.print("In-order Traversal: ");
        bst.inOrderTraversal();

        // Pre-order traversal of BST
        System.out.print("Pre-order Traversal: ");
        bst.preOrderTraversal();
    }
}