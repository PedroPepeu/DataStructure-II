package ed2.redBlack;

public class Main {

    public static void main(String[] args) {
        
        RBTree tree = new RBTree();
        int a[] = {41, 14, 51, 90, 64, 43, 37, 99, 18, 100};

        for(int x : a) {
            tree.insert(x);
        }

        tree.levelOrder();
    }
    
}
