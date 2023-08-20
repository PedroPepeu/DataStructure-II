package ed2;

import org.w3c.dom.Node;

// class TreeNode<Key extends Comparable<Key>, T> {

//     private Key key;
//     private T value;
//     private int balFac;
//     private TreeNode<Key, T> left;
//     private TreeNode<Key, T> right;

//     TreeNode(Key key, T value) {
//         this.key = key;
//     }
    
// }

public class BinaryThree<Key extends Comparable<Key>, T> {
    
    private TreeNode<Key, T> root;
    private int size;

    public BinaryThree() {
        this.size = 0;
    }

    public BinaryThree(TreeNode<Key, T> root, int size) {
        this.root = root;
        this.size = size;
    }

    int size(TreeNode<Key, T> tn) {
        if(tn == null) return 0;

        return tn.getSize();
    }

    int max(int a, int b) {
        if(a > b) return a;
        else return b;
    }

    TreeNode<Key, T> rightRotate(TreeNode<Key, T> tn) {
        TreeNode<Key, T> leftNode = tn.getLeft();
        TreeNode<Key, T> rightLNode = leftNode.getRight();

        leftNode.setRight(tn);
        tn.setLeft(rightLNode);

        tn.setSize(max(size(tn.getLeft()), size(tn.getRight())) + 1);
        leftNode.setSize(max(size(leftNode.getLeft()), size(leftNode.getRight())) + 1);

        return leftNode;
    }

    TreeNode<Key, T> leftRotate(TreeNode<Key, T> tn) {
        TreeNode<Key, T> rightNode = tn.getRight();
        TreeNode<Key, T> leftRNode = rightNode.getLeft();

        rightNode.setLeft(tn);
        tn.setRight(leftRNode);

        tn.setSize(max(size(tn.getLeft()), size(tn.getRight())) + 1);
        rightNode.setSize(max(size(tn.getLeft()), size(tn.getRight())));

        return rightNode;
    }

    private T get(Key key, TreeNode<Key, T> currNode) {
        if (currNode == null) return null;

        int cmp = key.compareTo(currNode.getKey());
        
        if(cmp < 0) return get(key, currNode.getLeft());
        else if(cmp > 0) return get(key, currNode.getRight());
        else return currNode.getValue();
    }

    int getBalance(TreeNode<Key, T> tn) {
        if(tn == null) return 0;
        return size(tn.getLeft()) - size(tn.getRight());
    }

    public void insert(Key key, T value) {
        setRoot(insert(key, value, getRoot()));
        setSize(size() + 1); // fix the size recalculation, or put in insert private
    }

    private TreeNode<Key, T> insert(TreeNode<Key, T> tn, Key key, T value) {

        if(tn == null) {
            TreeNode<Key, T> newNode = new TreeNode<Key, T>(key, value, null, null);
            return newNode;
        }

        int cmp = key.compareTo(tn.getKey());

        TreeNode<Key, T> rightSubtree = new TreeNode<Key, T>(null, null, null, null);
        TreeNode<Key, T> leftSubtree = new TreeNode<Key, T>(null, null, null, null);

        if(cmp < 0) {
            leftSubtree = insert(tn.getRight(), key, value);
            tn.setLeft(leftSubtree);
        } else {
            rightSubtree = insert(tn.getRight(), key, value);
            tn.setRight(rightSubtree);
        }

        tn.setSize(leftSubtree.getSize() + rightSubtree.getSize() + 1);
        return tn;

    }

    private TreeNode<Key, T> searchMin(TreeNode<Key, T> currNode) {
        if (currNode == null) return null;
        while(currNode.getLeft() != null) {
            currNode = currNode.getLeft();
        }
        return currNode;
    }

    private TreeNode<Key, T> searchMax(TreeNode<Key, T> currNode) {
        if (currNode == null) return null;
        while(currNode.getRight() != null) {
            currNode = currNode.getRight();
        }
        return currNode;
    }

    public void delete(Key key) {
        delete(key, root);
    }

    private TreeNode<Key, T> delete(Key key, TreeNode<Key, T> currNode) {
        if (currNode == null) return null;

        int cmp = key.compareTo(currNode.getKey());

        if(cmp < 0) currNode.setLeft(delete(key, currNode.getLeft()));
        else if(cmp > 0) currNode.setRight(delete(key, currNode.getRight()));
        else {
            if(currNode.getLeft() == null) return currNode.getRight();
            else if(currNode.getRight() == null) return currNode.getLeft();
            else {
                TreeNode<Key, T> n = min(currNode.getRight());
                currNode.setKey(n.getKey());
                TreeNode<Key, T> r = delete(currNode.getKey(), currNode.getRight());
                currNode.setRight(r);
            }
        }
        if(currNode.getLeft() == null && currNode.getRight() == null) {
            currNode.setSize(1);
        } else if(currNode.getLeft() == null) {
            currNode.setSize(1 + currNode.getRight().getSize());
        } else if (currNode.getRight() == null) {
            currNode.setSize(1 + currNode.getLeft().getSize());
        } else {
            currNode.setSize(1 + currNode.getLeft().getSize() + currNode.getRight().getSize());
        } // discusting
            
        return currNode;
    }

    public TreeNode<Key, T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<Key, T> root) {
        this.root = root;
    }


}
