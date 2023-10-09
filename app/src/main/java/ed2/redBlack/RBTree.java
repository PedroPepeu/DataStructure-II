package ed2.redBlack;

import java.util.LinkedList;
import java.util.Queue;

public class RBTree<T extends Comparable<T>> {
    
    private RBNode<T> root;

    public RBTree(RBNode<T> root) {
        this.root = root;
    }

    public RBTree() {}

    private void fixInsert(RBNode<T> currentNode) {
        RBNode<T> node;
        while (currentNode.getParent().getColor() == Color.RED) {
            
            if (currentNode.getParent() == currentNode.getParent().getParent().getRight()) {
            
                node = currentNode.getParent().getParent().getLeft();
                
                if (node.getColor() == Color.RED) {
                    
                    node.setColor(Color.BLACK);
                    currentNode.getParent().setColor(Color.BLACK);
                    currentNode.getParent().getParent().setColor(Color.RED);
                    currentNode = currentNode.getParent().getParent();
                
                } else {
                    
                    if (currentNode == currentNode.getParent().getLeft()) {
                        currentNode = currentNode.getParent();
                        rightRotate(currentNode);
                    }
                    
                    currentNode.getParent().setColor(Color.BLACK);
                    currentNode.getParent().getParent().setColor(Color.RED);
                    leftRotate(currentNode.getParent().getParent());
                }
            
            } else {
            
                node = currentNode.getParent().getParent().getRight();

                if (node.getColor() == Color.RED) {
                
                    node.setColor(Color.BLACK);
                    currentNode.getParent().setColor(Color.BLACK);
                    currentNode.getParent().getParent().setColor(Color.RED);
                    currentNode = currentNode.getParent().getParent();
                
                } else {
                    
                    if (currentNode == currentNode.getParent().getRight()) {
                        currentNode = currentNode.getParent();
                        leftRotate(currentNode);
                    }
                    
                    currentNode.getParent().setColor(Color.BLACK);
                    currentNode.getParent().getParent().setColor(Color.RED);
                    rightRotate(currentNode.getParent().getParent());
                
                }
            }
            
            if (currentNode == root) {
                break;
            }
        }
        root.setColor(Color.BLACK);
    }

    public void insert(T info) {
        RBNode<T> currentNode = new RBNode<T>(info);
        currentNode.setParent(null);

        RBNode<T> nodeY = null;
        RBNode<T> nodeX = this.root;

        while (nodeX != null) {
            nodeY = nodeX;

            int cmp = info.compareTo(nodeX.getInfo());
            if (cmp < 0) {
                nodeX = nodeX.getLeft();
            } else {
                nodeX = nodeX.getRight();
            }
        }

        int cmp = info.compareTo(nodeY.getInfo());
        currentNode.setParent(nodeY);
        if (cmp == 0) {
            setRoot(currentNode);
        } else if (cmp < 0) {
            nodeY.setLeft(currentNode);
        } else {
            nodeY.setRight(currentNode);
        }

        if (currentNode.getParent() == null) {
            currentNode.setColor(Color.BLACK);
            return;
        }

        if (currentNode.getParent().getParent() == null) {
            return;
        }

        fixInsert(currentNode);
    }

    public void delete(T info) {
        
        RBNode<T> nodeToBeDeleted = search(info);
        if(nodeToBeDeleted == null) return;

        RBNode<T> auxNode = nodeToBeDeleted;
        RBNode<T> node;
        Color auxOriginColor = auxNode.getColor();

        if(nodeToBeDeleted.getLeft() == null) {
            node = nodeToBeDeleted.getRight();
            transplant(nodeToBeDeleted, nodeToBeDeleted.getLeft());
        } else if(nodeToBeDeleted.getRight() == null) {
            node = nodeToBeDeleted.getLeft();
            transplant(nodeToBeDeleted, nodeToBeDeleted.getLeft());
        } else {
            auxNode = minimum(nodeToBeDeleted.getRight());
            auxOriginColor = auxNode.getColor();
            node = auxNode.getRight();

            if(auxNode.getParent() == nodeToBeDeleted) node.setParent(auxNode);
            else {
                transplant(auxNode, auxNode.getRight());
                auxNode.setRight(nodeToBeDeleted.getRight());
                auxNode.getRight().setParent(auxNode);
            }

            transplant(nodeToBeDeleted, auxNode);
            auxNode.setLeft(nodeToBeDeleted.getLeft());
            auxNode.getLeft().setParent(auxNode);
            auxNode.setColor(nodeToBeDeleted.getColor());
        }

        if(auxOriginColor == Color.BLACK) fixDelete(node);

    }

    private RBNode<T> minimum(RBNode<T> currentNode) {
        while(currentNode != null) {
            currentNode = currentNode.getLeft();
        }

        return currentNode;
    }

    private void fixDelete(RBNode<T> currentNode) {
        while (currentNode != root && currentNode.getColor() == Color.BLACK) {
            if (currentNode == currentNode.getParent().getLeft()) {
                RBNode<T> w = currentNode.getParent().getRight();
                if (w.getColor() == Color.RED) {
                    w.setColor(Color.BLACK);
                    currentNode.getParent().setColor(Color.RED);
                    leftRotate(currentNode.getParent());
                    w = currentNode.getParent().getRight();
                }
                if (w.getLeft().getColor() == Color.BLACK && w.getRight().getColor() == Color.BLACK) {
                    w.setColor(Color.RED);
                    currentNode = currentNode.getParent();
                } else {
                    if (w.getRight().getColor() == Color.BLACK) {
                        w.getLeft().setColor(Color.BLACK);
                        w.setColor(Color.RED);
                        rightRotate(w);
                        w = currentNode.getParent().getRight();
                    }
                    w.setColor(currentNode.getParent().getColor());;
                    currentNode.getParent().setColor(Color.BLACK);
                    w.getRight().setColor(Color.BLACK);
                    leftRotate(currentNode.getParent());
                    currentNode = root;
                }
            } else {
                RBNode<T> w = currentNode.getParent().getLeft();
                if (w.getColor() == Color.RED) {
                    w.setColor(Color.BLACK);
                    currentNode.getParent().setColor(Color.RED);
                    rightRotate(currentNode.getParent());
                    w = currentNode.getParent().getLeft();
                }
                if (w.getRight().getColor() == Color.BLACK) {
                    w.setColor(Color.RED);
                    currentNode = currentNode.getParent();
                } else {
                    if (w.getLeft().getColor() == Color.BLACK) {
                        w.getRight().setColor(Color.BLACK);
                        w.setColor(Color.RED);
                        leftRotate(w);
                        w = currentNode.getParent().getLeft();
                    }
                    w.setColor(currentNode.getParent().getColor());
                    currentNode.getParent().setColor(Color.BLACK);
                    w.getLeft().setColor(Color.BLACK);
                    rightRotate(currentNode.getParent());
                    currentNode = root;
                }
            }
        }
        currentNode.setColor(Color.BLACK);
    }

    private void transplant(RBNode<T> nodeU, RBNode<T> nodeV) {
        if(nodeU.getParent() == null) setRoot(nodeV);
        else if(nodeU == nodeU.getParent().getLeft()) nodeU.getParent().setLeft(nodeV);
        else nodeU.getParent().setRight(nodeV);

        nodeV.setParent(nodeU.getParent());
    }

    private void leftRotate(RBNode<T> currentNode) {
        RBNode<T> node = currentNode.getRight();
        currentNode.setRight(node.getLeft());

        if(node.getLeft() != null) node.getLeft().setParent(currentNode);

        node.setParent(currentNode.getParent());

        if(currentNode.getParent() == null) setRoot(node);
        else {
            if(currentNode == currentNode.getParent().getLeft()) {
                currentNode.getParent().setLeft(node);
            } else {
                currentNode.getParent().setRight(node);
            }
        }

        node.setLeft(currentNode);
        currentNode.setParent(node);
    }

    private void rightRotate(RBNode<T> currentNode) {
        RBNode<T> node = currentNode.getLeft();
        currentNode.setLeft(node.getRight());

        if(node.getRight() != null) node.getRight().setParent(currentNode);

        node.setParent(currentNode.getParent());

        if(currentNode.getParent() == null) setRoot(node);
        else {
            if(currentNode == currentNode.getParent().getLeft()) {
                currentNode.getParent().setRight(node);
            } else {
                currentNode.getParent().setLeft(node);
            }
        }

        node.setRight(currentNode);
        currentNode.setParent(node);
    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(RBNode<T> node) {
        if (node == null) return;
         
        Queue<RBNode<T>> q = new LinkedList<>();
        RBNode<T> currentNode;
 
        q.add(node);
 
        while (!q.isEmpty()) {
            currentNode = q.poll();

            String color = currentNode.getColor() == Color.RED ? "red" : "black";
            System.out.printf("%s [%s] ", currentNode.getInfo(), color);
             
            if (currentNode.getLeft() != null) q.add(currentNode.getLeft());
            if (currentNode.getRight() != null) q.add(currentNode.getRight());
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(RBNode<T> node) {
        if (node == null)
            return;
 
        inorder(node.getLeft());

        String color = node.getColor() == Color.RED ? "red" : "black";
        System.out.printf("%s [%s]", node.getInfo(), color);

        inorder(node.getRight());
    }

    public RBNode<T> search(T info) {
        RBNode<T> currentNode = getRoot(); 
        
        while(currentNode != null) {
            int cmp = info.compareTo(currentNode.getInfo());
            
            if(cmp > 0) {
                currentNode = currentNode.getRight();
                continue;
            } else if(cmp < 0) {
                currentNode = currentNode.getLeft();
                continue;
            } else return currentNode;
        }

        return null;
    }

    public RBNode<T> getRoot() {
        return root;
    }

    public void setRoot(RBNode<T> root) {
        this.root = root;
    }

}
