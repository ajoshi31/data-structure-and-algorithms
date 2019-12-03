package KAryTree;

import java.util.ArrayList;
import java.util.stream.IntStream;

class CreateNAryFromGivenArray {

    void MakeTreeFromArrayDriver() {

        ArrayList<Integer> arrayOfRange = new ArrayList<>();
        int[] range = IntStream.iterate(1, n -> {
            arrayOfRange.add(n);
            return n + 1;
        }).limit(10).toArray();
        KAryNode rootNode = MakeNaryTreeFromArray(range, 1, 3);
        TraversePreOrderKAryTree traversePreOrderKAryTree = new TraversePreOrderKAryTree();
        traversePreOrderKAryTree.preOrder(rootNode);
    }

    private KAryNode MakeNaryTreeFromArray(int[] nodeValuesArray, int index, int kAry) {

        if (index > nodeValuesArray.length) {
            return null;
        }
        KAryNode node = new KAryNode(nodeValuesArray[index - 1]);
        int childPosition = index * kAry - (kAry - 2);
        for (int c = 0; c < kAry; c++) {
            node.getChildren().add(MakeNaryTreeFromArray(nodeValuesArray, childPosition + c, kAry));
        }
        return node;
    }

}

