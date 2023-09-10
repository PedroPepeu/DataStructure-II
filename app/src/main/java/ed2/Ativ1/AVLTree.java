package ed2.Ativ1;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<T extends Comparable <T>> {

    private AVLNode<T> root;

    // inserir CHECK
    // pesseioemordem CHECK
    // passeiopornivel CHECK

    public AVLTree(AVLNode<T> root, Integer size) {
        this.root = root;
    }

    public void insert(T info) {
        setRoot(insert(info, getRoot()));
    }

    private AVLNode<T> insert(T info, AVLNode<T> currentNode) {
        if(currentNode == null) {
            AVLNode<T> newNode = new AVLNode<T>(info);
            newNode.setFatBal(0);
            newNode.setHeight(1);
            return newNode;
        }

        int cmp = info.compareTo(currentNode.getInfo());

        AVLNode<T> leftSubtree = new AVLNode<T>(null);
        AVLNode<T> rightSubtree = new AVLNode<T>(null);

        if(cmp < 0) {
            leftSubtree = insert(info, currentNode.getLeft());
            currentNode.setLeft(leftSubtree);
        } 
        else {
            rightSubtree = insert(info, currentNode.getRight());
            currentNode.setRight(rightSubtree);
        }

        currentNode = updateNode(currentNode);

        return balance(currentNode);
    }

    private AVLNode<T> updateNode(AVLNode<T> nodeToBeUpdated) {
        int leftHeight;
        if(nodeToBeUpdated.getLeft() != null) leftHeight = nodeToBeUpdated.getLeft().getHeight();
        else leftHeight = 0;

        int rightHeight;
        if(nodeToBeUpdated.getRight() != null) rightHeight = nodeToBeUpdated.getRight().getHeight();
        else rightHeight = 0;

        nodeToBeUpdated.setHeight(Math.max(leftHeight, rightHeight) + 1);

        nodeToBeUpdated.setFatBal(rightHeight - leftHeight);
        return nodeToBeUpdated;
    }

    private AVLNode<T> balance(AVLNode<T> node) {
        // rotacao simples esquerda
        if (node.getFatBal() < -1 && node.getLeft() != null && node.getLeft().getFatBal() <= 0) {
            return rightRotate(node);
        }
    
        // rotacao simples direita
        if (node.getFatBal() > 1 && node.getRight() != null && node.getRight().getFatBal() >= 0) {
            return leftRotate(node);
        }
    
        // rotacao dupla para a direita
        if (node.getFatBal() < -1 && node.getLeft() != null && node.getLeft().getFatBal() > 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
    
        // rotacao dupla para a esquerda
        if (node.getFatBal() > 1 && node.getRight() != null && node.getRight().getFatBal() < 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
    
        return node;
    }

    // rotacao simples direita
    private AVLNode<T> leftRotate(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getRight();
        AVLNode<T> subtree = newRoot.getLeft();
        newRoot.setLeft(node);
        node.setRight(subtree);

        node = updateNode(node);
        newRoot = updateNode(newRoot);

        return newRoot;
    }

    // rotacao simples esquerda
    private AVLNode<T> rightRotate(AVLNode<T> node) {
        AVLNode<T> newRoot = node.getLeft();
        AVLNode<T> subtree = newRoot.getRight();
        newRoot.setRight(node);
        node.setLeft(subtree);

        node = updateNode(node);
        newRoot = updateNode(newRoot);

        return newRoot;
    }

    public void nodeRemove(T info) {
        root = nodeRemove(info, root);
    }

    private AVLNode<T> nodeRemove(T info, AVLNode<T> currentNode) {
        if(currentNode == null) return null;

        int cmp = info.compareTo(currentNode.getInfo());

        if (cmp < 0) {
            currentNode.setLeft(nodeRemove(info, currentNode.getLeft()));
        } else if (cmp > 0) {
            currentNode.setRight(nodeRemove(info, currentNode.getRight()));
        } else {

            if (currentNode.getLeft() == null && currentNode.getRight() == null) return null;
            else if (currentNode.getLeft() == null) return currentNode.getRight();
            else if (currentNode.getRight() == null) return currentNode.getLeft();
            else {
                AVLNode<T> nextNode = findMin(currentNode.getRight());
                currentNode.setInfo(nextNode.getInfo());
                currentNode.setRight(nodeRemove(nextNode.getInfo(), currentNode.getRight()));
            }

        }

        currentNode = updateNode(currentNode);

        return balance(currentNode);
    }

    private AVLNode<T> findMin(AVLNode<T> node) {
        while(node.getLeft() != null) node = node.getLeft();
        return node;
    }

    private AVLNode<T> findMax(AVLNode<T> node) {
        while(node.getRight() != null) node = node.getRight();
        return node;
    }

    public void InOrder() {
        InOrder(getRoot());
        return;
    }

    private void InOrder(AVLNode<T> currentNode) {
        if(currentNode == null) return;

        InOrder(currentNode.getLeft());

        System.out.printf("%s\n", currentNode.getInfo().toString());

        InOrder(currentNode.getRight());

        return;
    }

    public void BreadthFirst() {
        BreadthFirst(getRoot());
        return;
    }

    private void BreadthFirst(AVLNode<T> currentNode) {
        if(currentNode == null) return;
        
        Queue<AVLNode<T>> Qnodes = new LinkedList<AVLNode<T>>();
        Qnodes.add(currentNode);
        int k = 1, s = 1;

        while(!Qnodes.isEmpty()) {
            currentNode = Qnodes.poll();
            System.out.printf("%s ", currentNode.getInfo().toString());
            if(k == 0) {
                System.out.println();
                k = s*=2;
            } else k--;
            if(currentNode.getLeft() != null) Qnodes.add(currentNode.getLeft());
            if(currentNode.getRight() != null) Qnodes.add(currentNode.getRight());
        }

        return;
    }

    public AVLNode<T> getRoot() {
        return root;
    }

    public void setRoot(AVLNode<T> root) {
        this.root = root;
    }
}
