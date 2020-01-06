package StringAlgorithm.TernarySearchTree;

public class TSTNode {

    public char data;
    public boolean isEndOfString;
    public TSTNode left, middle, right;

    public TSTNode(char data) {
        this.data = data;
        this.isEndOfString = false;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}
