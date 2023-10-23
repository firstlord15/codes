class BT_run{
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();

        int[] anArrayNodes = {
                17, 6, 5, 20, 19, 18, 11, 14, 12, 13, 2, 4, 10
        };

        for (int i = 0; i < anArrayNodes.length; i++) {
            tree.add(anArrayNodes[i]);
        }

        // Checking if the tree is empty
        System.out.println("Is the tree empty? "+tree.isEmpty());

        // Getting the size of the tree
        System.out.println("Size of the tree: "+tree.getSize());

        // Searching for a value in the tree
        int value = 7;
        System.out.println("Does the tree contain "+value +"? "+tree.containsNode(value));

        // Deleting a node from the tree
        tree.delete(3);

        // Traversing the tree in different orders
        System.out.print("Inorder traversal: ");
        tree.traverseInOrder(tree.root);
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.traversePreOrder(tree.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.traversePostOrder(tree.root);
        System.out.println();

        System.out.print("Level-order traversal: ");
        tree.traverseLevelOrder();
        System.out.println();

        System.out.print("Inorder traversal without recursion: ");
        tree.traverseInOrderWithoutRecursion();
        System.out.println();

        System.out.print("Preorder traversal without recursion: ");
        tree.traversePreOrderWithoutRecursion();
        System.out.println();

        System.out.print("Postorder traversal without recursion: ");
        tree.traversePostOrderWithoutRecursion();
        System.out.println();
    }

}