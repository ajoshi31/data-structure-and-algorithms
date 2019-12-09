package KAryTree;

import java.util.ArrayList;

class TraversePreOrderKAryTree {
    private ArrayList<Integer> nodes;

    void preOrder(KAryNode root) {
        nodes = new ArrayList<>();
        preOrderUtil(root);
        for (Integer node : nodes) {
            System.out.print(node + " ");
        }
    }

    private void preOrderUtil(KAryNode node) {
        if (node == null) {
            return;
        }
        nodes.add(node.getValue());
        for (KAryNode aNode : node.getChildren()) {
            preOrderUtil(aNode);
        }

    }
}
