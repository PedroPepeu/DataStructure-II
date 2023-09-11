package ed2.Ativ1;

public class Main {

    public static void main(String[] args) {
        
        AVLTree tree = new AVLTree();
        int a[] = {30, 40, 60, 70, 20, 10, 15, 25, 35, 65};

        for(int i : a) {
            tree.insert(i);
            tree.BreadthFirst();
            tree.InOrder();
        }
        
        tree.BreadthFirst();
        tree.InOrder();
        int b[] = {65, 60, 70, 30};
        for(int i : b) {
            tree.remove(i);
            tree.BreadthFirst();
        }
    }
    
}
