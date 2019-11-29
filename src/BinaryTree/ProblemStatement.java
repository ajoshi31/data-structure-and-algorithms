package BinaryTree;

import BinaryTree.problems.*;

class ProblemStatement {
    void functionToRun(String functionName, BinaryTreeNode node) {

        BinaryTreeUtilsFunctions utilFunctions = new BinaryTreeUtilsFunctions();
        switch (Problems.valueOf(functionName.toUpperCase())) {

            case PROBLEM0:
                NonRecursiveBinaryTreeTraversal nonRecursiveBinaryTreeTraversal = new NonRecursiveBinaryTreeTraversal();
                nonRecursiveBinaryTreeTraversal.printLevelOrder(node);
                break;

            case PROBLEM1:
                System.out.print("\n\nSize of binary Tree : " + String.valueOf(utilFunctions.sizeOfBinaryTree(node)));
                break;

            case PROBLEM2:
                System.out.print("\n\nMaximum Value in Tree is; " + String.valueOf(utilFunctions.maxElementInBinaryTree(node)));
                break;

            case PROBLEM9: {
                ReverseLevelOrder reverseLevelOrder = new ReverseLevelOrder();
                reverseLevelOrder.levelOrderTraversalInReverse(node);
                break;
            }

            case PROBLEM10: {
                System.out.print("\n\nHeight of binary Tree : " + String.valueOf(utilFunctions.heightOfTree(node)));
                break;
            }

            case PROBLEM13: {
                MinimumDepthOfBinaryTree mdbt = new MinimumDepthOfBinaryTree();
                System.out.print("\n\nMinimum Depth of binary Tree : " + String.valueOf(mdbt.minimumDepthOfTree(node)));
                break;
            }

            case PROBLEM14: {
                DeepestNodeInBinaryTree dnbt = new DeepestNodeInBinaryTree();
                dnbt.deepMostLeftLeafNode(node);
                break;
            }

            case PROBLEM15: {
                DeepestNodeInBinaryTree dnbt = new DeepestNodeInBinaryTree();
                System.out.print("\n\nDeepest Node In Binary Tree: " + String.valueOf(dnbt.deepestNodeInBinaryTreeWithQueue(node).getData()));
                break;
            }

            case PROBLEM15_1: {
                new DeepestNodeInBinaryTree().getAllDeepestNodes(node);
                break;
            }
            case PROBLEM16: {
                new DeepestNodeInBinaryTree().countAllLeafNodeWithoutRecursion(node);
                break;
            }

            case PROBLEM16_1: {
                new DeepestNodeInBinaryTree().countAllLeafNodeUsingRecursion(node);
                break;
            }

            case PROBLEM17: {
                new DeepestNodeInBinaryTree().getAllLeafNode(node);
                break;
            }

            case PROBLEM20: {
                new DiameterOfBinaryTree().getDiameterOfBinaryTree(node);
                break;
            }

            case PROBLEM21_1: {
                WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
                System.out.print("\n\n The maximum width of the tree is: " + widthOfBinaryTree.maxWidthOfBinaryTreeWithLevelOrder(node));
                break;
            }

            case PROBLEM21_2: {
                WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
                System.out.print("\n\n The maximum width of the tree is: " + widthOfBinaryTree.maxWidthUsingPreOrderTraversal(node));
                break;
            }

            case PROBLEM22: {
                LevelWithMaximumSum levelWithMaximumSum = new LevelWithMaximumSum();
                System.out.print("\n\n The maximum sum in the level: " + levelWithMaximumSum.levelWithMaximumSum(node));
                break;
            }
            default:
                // code block
        }
    }


    public enum Problems {
        PROBLEM0,
        PROBLEM1,
        PROBLEM2,
        PROBLEM9,
        PROBLEM10,
        PROBLEM13,
        PROBLEM14,
        PROBLEM15,
        PROBLEM15_1,
        PROBLEM16,
        PROBLEM16_1,
        PROBLEM17,
        PROBLEM20,
        PROBLEM21_1,
        PROBLEM21_2,
        PROBLEM22
    }
}


//        BinaryTreeTraversal btt = new BinaryTreeTraversal();
//        NonRecursiveBinaryTreeTraversal bttNonRecur = new NonRecursiveBinaryTreeTraversal();
//        BinaryTreeUtilsFunctions utilFunctions = new BinaryTreeUtilsFunctions();

//        System.out.println("\n\nPrint the pre order traversal");
//        btt.preOrderTraversal(binaryTree.root);
//        System.out.println("\n\nNon recursive");
//        bttNonRecur.preOrderTraversal(binaryTree.root);
//
//        System.out.println("\n\nPrint the In order traversal");
//        btt.inOrderTraversal(binaryTree.root);
//        System.out.println("\n\nNon recursive");
//        bttNonRecur.inOrderTraversal(binaryTree.root);
//
//        System.out.println("\n\nPrint the Post order traversal");
//        btt.postOrderTraversal(binaryTree.root);
//        System.out.println("\n\nNon recursive");
//        bttNonRecur.postOrderTraversal(binaryTree.root);
//
//        System.out.print("\n\nLevel Order\n");
//        bttNonRecur.printLevelOrder(binaryTree.root);
//
