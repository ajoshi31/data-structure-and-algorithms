package StringAlgorithm.TernarySearchTree;

public class TST<Value> {

    private TSTNode root;

    public static void main(String args[]) {
        // implement tst
        TST tst = new TST();

        tst.insertInTST("tree");
        tst.insertInTST("sea");
        tst.insertInTST("eat");
        tst.insertInTST("eating");

        System.out.println(tst.searchTST("eat"));
        System.out.println(tst.searchTST("eating"));
        System.out.println(tst.searchTST("eatr"));
    }


    /* Insert */

    private void insertInTST(String str) {
        root = insertUtil(root, str, 0);
    }

    private TSTNode insertUtil(TSTNode node, String str, int position) {

        char ch = str.charAt(position);
        if (node == null) {
            node = new TSTNode(ch);
        }
        if (ch < node.data) {
            node.left = insertUtil(node.left, str, position);
        } else if (ch < node.data) {
            node.right = insertUtil(node.right, str, position);
        } else {
            if (position < str.length() - 1) {
                node.middle = insertUtil(node.middle, str, position + 1);
            } else {
                node.isEndOfString = true;
            }
        }
        return node;
    }

    private boolean searchTST(String str) {
        return searchTSTUtli(root, str, 0);
    }

    private boolean searchTSTUtli(TSTNode node, String str, int position) {
        if (str.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        char ch = str.charAt(position);
        if (node == null) {
            return false;
        }
        if (ch < node.data) {
            return searchTSTUtli(node.left, str, position);
        } else if (ch > node.data) {
            return searchTSTUtli(node.right, str, position);
        } else {
            if (position < str.length() - 1) {
                return searchTSTUtli(node.middle, str, position + 1);
            } else {
                return node.isEndOfString;
            }
        }
    }

    private void traverse(String str) {
        traverseUtil(root, str, 0);
    }

    private void traverseUtil(TSTNode node, String str, int position) {
        if(root == null){
            return;
        }

    }

}
