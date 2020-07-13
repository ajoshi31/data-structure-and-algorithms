package BinaryTree.problems;

/* *
* Leet Code Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
* */

import BinaryTree.BinaryTreeNode;

import java.util.*;

public class LevelOrderTraversalLevelWise {

    public void LevelOrderTraversalLevelWise(BinaryTreeNode node) {
        List<List<Integer>> listArray = levelOrderBottom(node);
        System.out.println(listArray.toString());
        Collections.reverse(listArray);
        System.out.println(listArray.toString());


    }

    private List<List<Integer>> levelOrderBottom(BinaryTreeNode root) {

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int n = queue.size();

            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                BinaryTreeNode tempNode = queue.poll();
                row.add(tempNode.getData());
                if (tempNode.getLeft() != null) {
                    queue.add(tempNode.getLeft());
                }
                if (tempNode.getRight() != null) {
                    queue.add(tempNode.getRight());
                }
            }
            result.add(row);
        }
        return result;

    }

}

/*
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }


import java.util.*;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int n = queue.size();

            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode tempNode = queue.poll();
                row.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            result.add(row);
        }
        Collections.reverse(result);
        return result;
    }
}
 */
