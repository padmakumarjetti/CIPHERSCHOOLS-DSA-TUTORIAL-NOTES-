class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    BinarySearchTree() {
        root = null;
    }

    // Search a key in the BST
    TreeNode search(int key) {
        return searchRec(root, key);
    }

    // Recursive function to search a key in the BST
    TreeNode searchRec(TreeNode root, int key) {
        if (root == null || root.key == key)
            return root;

        if (root.key > key)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    // Insert a new key in the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new key in the BST
    TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Delete a key from the BST
    void delete(int key) {
        root = deleteRec(root, key);
    }

    // Recursive function to delete a key from the BST
    TreeNode deleteRec(TreeNode root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(TreeNode root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Print Inorder traversal of the BST
    void inorder() {
        inorderRec(root);
    }

    // Recursive function for inorder traversal
    void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal of the BST:");
        bst.inorder();

        System.out.println("\n\nDelete 20");
        bst.delete(20);
        System.out.println("Inorder traversal of the modified BST:");
        bst.inorder();

        System.out.println("\n\nDelete 30");
        bst.delete(30);
        System.out.println("Inorder traversal of the modified BST:");
        bst.inorder();

        System.out.println("\n\nDelete 50");
        bst.delete(50);
        System.out.println("Inorder traversal of the modified BST:");
        bst.inorder();
    }
}
