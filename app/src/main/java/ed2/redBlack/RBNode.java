package ed2.redBlack;

enum Color {
    RED,
    BLACK;
}

public class RBNode<T extends Comparable <T>> {

//     Implemente, em Java, uma árvore red-black genérica com os seguintes métodos:
// 1 - Inserir
// 2 - Passeio por nível
// 3 - Passeio em ordem
// 4 - Buscar
// 5 - Remover (preguiçoso)
// OBS: Os métodos de passeio devem exibir a informação e a cor de cada nó. 
    
    private RBNode<T> left;
    private RBNode<T> right;
    private RBNode<T> parent;
    private T info;
    private Color color;
    
    public RBNode(T info) {
        this.info = info;
        this.color = Color.RED;
    }

    public RBNode<T> getLeft() {
        return left;
    }

    public void setLeft(RBNode<T> left) {
        this.left = left;
    }

    public RBNode<T> getRight() {
        return right;
    }

    public void setRight(RBNode<T> right) {
        this.right = right;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public RBNode<T> getParent() {
        return parent;
    }

    public void setParent(RBNode<T> parent) {
        this.parent = parent;
    }
    
}
