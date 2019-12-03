package BinaryTree;

public class Main {

    public static void main(String[] args) {
        //Initialise root
        BinaryTreeNode root = new BinaryTreeNode(40);

        //Create a binary Tree
        InitialiseBinaryTree initialiseBinaryTree = new InitialiseBinaryTree();
        initialiseBinaryTree.initialise(root);

        //Problem Statement To Solve
        ProblemStatement problemStatement = new ProblemStatement();
        problemStatement.functionToRun("PROBLEM34", root);
    }

}


