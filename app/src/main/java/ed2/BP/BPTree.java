package ed2.BP;

import java.util.List;
import java.util.ArrayList;

public class BPTree<K extends Comparable <K>> {

    BPNode<K> root;
    int order;

    public BPTree(BPNode<K> root) {
        this.root = root;
    }

    public BPTree() {}

    public void insert(K key) {
        setRoot(insert(key, getRoot()));
    }

    private BPNode<K> insert(K key, BPNode<K> currNode) {
        if (currNode == null) {
            BPNode<K> node = new BPNode<>();
            List<K> keysNode = new ArrayList<>();
            keysNode.add(key);
            node.setKeys(keysNode);
            return node;
        }

        if(!currNode.isLeaf()) {
            List<K> lNode = currNode.getKeys();
            int i;
            for(i = 0; i < currNode.getKeys().size(); i++) {
                if(key.compareTo(lNode.get(i)) < 0) {
                    break;
                }
            }
            return currNode.getChildren().get(i+1);
        }

        if(currNode.getKeys().size() < order) {
            List<K> auxNode = currNode.getKeys();
            auxNode.add(key);
            
        }
        


        return null;
    }

    private BPNode<K> split(BPNode<K> nodeToSplit) {
        return null;
    }

    public void delete(K key) {

    }

    public void search(K key) {

    }

    private BPNode<K> getRoot() {
        return root;
    }

    private void setRoot(BPNode<K> root) {
        this.root = root;
    }

}
