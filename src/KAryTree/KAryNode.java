package KAryTree;

import java.util.ArrayList;

public class KAryNode {

    private int value;
    private ArrayList<KAryNode> children;

    int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    ArrayList<KAryNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<KAryNode> children) {
        this.children = children;
    }

    KAryNode(int _val) {
        this.value = _val;
        this.children = new ArrayList<KAryNode>();
    }
}

