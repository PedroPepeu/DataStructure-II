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
            return newNode;
        }

        int cmp = info.compareTo(currentNode.getInfo());

        AVLNode<T> leftSubtree = new AVLNode<T>(null);
        AVLNode<T> rightSubtree = new AVLNode<T>(null);

        if(cmp < 0) {
            leftSubtree = insert(info, currentNode.getLeft());
            currentNode.setLeft(leftSubtree);
            currentNode.setFatBal(currentNode.getFatBal() - 1);
        } 
        else {
            rightSubtree = insert(info, currentNode.getRight());
            currentNode.setRight(rightSubtree);
            currentNode.setFatBal(currentNode.getFatBal() + 1);
        }

        return currentNode;
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
