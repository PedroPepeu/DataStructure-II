package ed2.BP;

import java.util.List;
import java.util.ArrayList;

public class BPNode<K extends Comparable<K>> {
    
    private List<K> keys;
    private List<String> values;
    private List<BPNode<K>> children;
    private boolean isLeaf;

    public BPNode(List<K> keys, List<String> values, List<BPNode<K>> children) {
        this.keys = keys;
        this.values = values;
        this.children = children;
        this.isLeaf = true;
    }

    BPNode() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
        children = new ArrayList<>();
        isLeaf = true;
    }

    List<K> getKeys() {
        return keys;
    }

    List<String> getValues() {
        return values;
    }

    List<BPNode<K>> getChildren() {
        return children;
    }

    public void setKeys(List<K> keys) {
        this.keys = keys;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public void setChildren(List<BPNode<K>> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

}
