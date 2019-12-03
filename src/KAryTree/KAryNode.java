package KAryTree;

import java.util.ArrayList;

public class KAryNode {

    private int value;
    private ArrayList<KAryNode> children;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<KAryNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<KAryNode> children) {
        this.children = children;
    }

    public KAryNode(int _val) {
        this.value = _val;
        this.children = new ArrayList<KAryNode>();
    }
}

