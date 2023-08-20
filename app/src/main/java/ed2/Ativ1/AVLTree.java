package ed2.Ativ1;

public class AVLTree<T extends Comparable <T>> {

    private AVLNode<T> root;

    // inserir
    // pesseioemordem
    // passeiopornivel

    public AVLTree(AVLNode<T> root, Integer size) {
        this.root = root;
    }

    public void insert(T info) {
        setRoot(insert(info, getRoot()));
    }

    private AVLNode<T> insert(T info, AVLNode<T> currentNode) {
        if(currentNode == null) {
            AVLNode<T> newNode = new AVLNode<T>(info);
            return newNode;
        }

        int cmp = info.compareTo(currentNode.getInfo());

        AVLNode<T> leftSubtree = new AVLNode<T>(null);
        AVLNode<T> rightSubtree = new AVLNode<T>(null);

        if(cmp < 0) {
            leftSubtree = insert(info, currentNode.getLeft());
            currentNode.setLeft(leftSubtree);
        }
    }

    public AVLNode<T> getRoot() {
        return root;
    }

    public void setRoot(AVLNode<T> root) {
        this.root = root;
    }
}
