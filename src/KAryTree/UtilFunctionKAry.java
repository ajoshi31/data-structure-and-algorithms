package KAryTree;

public class UtilFunctionKAry {

    public int heightOfKAry(int nodes, int k) {
        return (int) Math.ceil(Math.log((double) nodes * (k - 1) + 1) /
                Math.log((double) k));
    }


    public void printPostOrder(KAryNode root, int k) {
        if (root == null)
            return;
        for (int i = 0; i < k; i++)
            printPostOrder(root.getChildren().get(i), k);
        System.out.print(root.getValue() + " ");
    }
}
