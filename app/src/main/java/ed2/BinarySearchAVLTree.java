package ed2;

public class BinarySearchAVLTree<Key extends Comparable<Key>, T> {
    TreeNode<Key, T> root;

    int height(TreeNode<Key, T> node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int balanceFactor(TreeNode<Key, T> node) {
        if (node == null)
            return 0;
        return height(node.getLeft()) - height(node.getRight);
    }

    TreeNode<Key, T> rotateRight(TreeNode<Key, T> y) {
        TreeNode<Key, T> x = y.getLeft();
        TreeNode<Key, T> T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.height = Math.max(height(y.getLeft()), height(y.getRight())) + 1;
        x.height = Math.max(height(x.getLeft()), height(x.getRight())) + 1;

        return x;
    }

    TreeNode<Key, T> rotateLeft(TreeNode<Key, T> x) {
        TreeNode<Key, T> y = x.getRight();
        TreeNode<Key, T> T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.height = Math.max(height(x.getLeft()), height(x.getRight())) + 1;
        y.height = Math.max(height(y.getLeft()), height(y.getRight())) + 1;

        return y;
    }

    TreeNode<Key, T> insert(TreeNode<Key, T> node, int key) {
        if (node == null)
            return new TreeNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys are not allowed
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        if (balance > 1 && key < node.left.key)
            return rotateRight(node);

        if (balance < -1 && key > node.right.key)
            return rotateLeft(node);

        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    void insertKey(int key) {
        root = insert(root, key);
    }

    TreeNode<Key, T> search(TreeNode<Key, T> node, int key) {
        if (node == null || node.key == key)
            return node;

        if (key < node.key)
            return search(node.left, key);
        else
            return search(node.right, key);
    }

    TreeNode<Key, T> searchKey(int key) {
        return search(root, key);
    }

}
