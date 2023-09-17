package ed2.Ativ1;

class AVLNode<T extends Comparable <T>> {

    private AVLNode<T> left;
    private T info;
    private int fatBal;
    private int height;
    private AVLNode<T> right;
    
    AVLNode (T value) {
        this.info = value;
        this.height = 1;
    }
    
    void setLeft (AVLNode<T> left) {
        this.left = left;
    }
    
    void setRight (AVLNode<T> right) {
        this.right = right;
    }
    
    void setInfo (T value) {
        this.info = value;
    }
    
    void setFatBal (int fb) {
        this.fatBal = fb;
    }

    void setHeight(int height) {
        this.height = height;
    }
    
    AVLNode<T> getLeft () {
        return this.left;
    }
    
    AVLNode<T> getRight () {
        return this.right;
    }
    
    T getInfo () {
        return this.info;
    }
    
    int getFatBal () {
        return this.fatBal;
    }

    int getHeight() {
        return this.height;
    }
    
}