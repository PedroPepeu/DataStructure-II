package ed2.B;

class Bnode<T extends Comparable<T>> {

    private T keys[];
    private int m; // size
    private Bnode nChilds[]; // m + 1
    private int numOfKeys;
    private boolean leaf;
    private int keysAllocated;

    public Bnode (int m, boolean leaf) {
        this.keys = new T[m*m];
        this.nChilds = new Bnode[(m*m)+1];
        this.m = m;
        this.leaf = leaf;
        this.numOfKeys = 0;
        this.keysAllocated = 0;
    }

    public T[] getKeys() {
        return keys;
    }

    public void setKeys(T[] keys) {
        this.keys = keys;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public Bnode[] getnChilds() {
        return nChilds;
    }

    public void setnChilds(Bnode[] nChilds) {
        this.nChilds = nChilds;
    }

    public int getNumOfKeys() {
        return numOfKeys;
    }

    public void setNumOfKeys(int numOfKeys) {
        this.numOfKeys = numOfKeys;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public int getKeysAllocated() {
        return keysAllocated;
    }

    public void setKeysAllocated(int keysAllocated) {
        this.keysAllocated = keysAllocated;
    }

}
