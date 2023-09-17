package ed2.Ativ1;

public class Main {

    public static void main(String[] args) {
        
        AVLTree tree = new AVLTree();
        int a[] = {1, 3, 2};

        for(int i : a) {
            tree.insert(i);
            tree.BreadthFirst();
        }
        
    }
    
}
