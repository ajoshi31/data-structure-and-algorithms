package StringAlgorithm.TernarySearchTree;


public class TST<Value> {

    private TSTNode root;

    public static void main(String args[]) {
        // implement tst
        TST tst = new TST();

        tst.insertInTST("cat");
        tst.insertInTST("cats");
        tst.insertInTST("bump");
        tst.insertInTST("bug");
        tst.insertInTST("up");
        tst.insertInTST("upset");
        tst.insertInTST("set");
        tst.insertInTST("bat");

        System.out.println(tst.searchTST("up"));
        System.out.println(tst.searchTST("eating"));
        System.out.println(tst.searchTST("ups"));

        tst.traverse();
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
        } else if (ch > node.data) {
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

    private void traverse() {
        char[] buffer = new char[10];
        traverseUtil(root, buffer, 0);
    }

    private void traverseUtil(TSTNode node, char[] buffer, int position) {
        if (node == null) {
            return;
        }

        traverseUtil(node.left, buffer, position);
        buffer[position] = node.data;
        if (node.isEndOfString) {
            buffer[position + 1] = '\0';
            String str = new String(buffer);
            System.out.println(str);

        }
        traverseUtil(node.middle, buffer, position + 1);

        traverseUtil(node.right, buffer, position);


    }

}
