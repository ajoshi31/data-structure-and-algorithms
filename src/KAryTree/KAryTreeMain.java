package KAryTree;

import java.util.LinkedList;

public class KAryTreeMain {
    public static void main(String args[]) {
        int k = 3, n = 10;
        int preOrder[] = {1, 2, 5, 6, 7, 3, 8, 9, 10, 4};
        UtilFunctionKAry utilFunctionKAry = new UtilFunctionKAry();
        CreateKAryTree createKAryTree = new CreateKAryTree();
        CreateNAryFromGivenArray createNAryFromGivenArray = new CreateNAryFromGivenArray();
        KAryNode root = createKAryTree.buildKaryTree(preOrder, n, k, utilFunctionKAry.heightOfKAry(n, k));
        utilFunctionKAry.printPostOrder(root, k);
        System.out.println();
        TraversePreOrderKAryTree traversePreOrderKAryTree = new TraversePreOrderKAryTree();
        traversePreOrderKAryTree.preOrder(root);
        System.out.println();
        createNAryFromGivenArray.MakeTreeFromArrayDriver();
        LinkedList a = new LinkedList();
    }
}