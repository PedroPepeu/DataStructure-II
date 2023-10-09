package ed2.B;

public class Btree<T extends Comparable<T>> {

    private Bnode<T> root;
    private int m;

    public Btree(Bnode<T> root, int m) {
        this.root = root;
        this.m = m;
    }

    public Btree(int m) {
        this.m = m;
    }

    public void insert(T key) {
        setRoot(insert(key, getRoot()));
    }

    private Bnode<T> insert(T key, Bnode<T> currentNode) {
        if(currentNode == null) {
            Bnode<T> node = new Bnode<T>(getM(), true);
            node.getKeys()[0] = key;
            node.setKeysAllocated(1);;
            return node;
        }

        if(currentNode.getKeysAllocated() == (2*currentNode.getM()-1)) {
            Bnode<T> newRoot = new Bnode<>(m, false);
            newRoot.getnChilds()[0] = currentNode;
            split(newRoot, 0);
            return newRoot;
        }

        return insertNonFull(currentNode, key);
    }

    private Bnode<T> insertNonFull(Bnode<T> currentNode, T key) {
        int i = currentNode.getKeysAllocated() - 1;
        int cmp = key.compareTo(currentNode.getKeys()[i]);
        
        if(currentNode.isLeaf()) {
            while(i >= 0 && cmp < 0) {
                currentNode.getKeys()[i + 1] = currentNode.getKeys()[i];
                i--;
            }
            currentNode.getKeys()[i+1] = key;
            currentNode.setKeysAllocated(currentNode.getKeysAllocated()+1);

            return currentNode;
        } 
        
        while(i >= 0 && cmp < 0) {
            i--;
        }
        i++;
        if(currentNode.getnChilds()[i].getKeysAllocated() == (2*currentNode.getM()-1)) {
            split(currentNode, i);
            if(key.compareTo(currentNode.getKeys()[i]) > 0) i++;
        }
        return insertNonFull(currentNode.getnChilds()[i], key);
    }

    public void delete(T key) {

    }

    private Bnode<T> delete(Bnode<T> node) {

    }

    private void split(Bnode<T> parentNode, int idx) {
        Bnode<T> childNode = parentNode.getnChilds()[idx];
        Bnode<T> newChildNode = new Bnode<T>(getM(), childNode.isLeaf());

        for(int i = 0; i < getM() - 1; i++) {
            newChildNode.getKeys()[i] = childNode.getKeys()[i+getM()];
            childNode.getnChilds()[i+getM()] = null;
        }

        if (!childNode.isLeaf()) {
            for (int i = 0; i < getM(); i++) {
                newChildNode.getnChilds()[i] = childNode.getnChilds()[i + getM()];
                childNode.getnChilds()[i + getM()] = null;
            }
        }

        for (int i = parentNode.getNumOfKeys(); i > idx; i--) {
            parentNode.getnChilds()[i + 1] = parentNode.getnChilds()[i];
            parentNode.getKeys()[i] = parentNode.getKeys()[i - 1];
        }

        parentNode.getnChilds()[idx + 1] = newChildNode;
        parentNode.getKeys()[idx] = childNode.getKeys()[getM() - 1];
        childNode.getKeys()[getM() - 1] = null;
        parentNode.setKeysAllocated(parentNode.getKeysAllocated()+1);
    }

    public Bnode<T> getRoot() {
        return root;
    }

    public void setRoot(Bnode<T> root) {
        this.root = root;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }
    
}
