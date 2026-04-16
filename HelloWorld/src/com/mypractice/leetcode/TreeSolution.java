package com.mypractice.leetcode;

import com.mypractice.module.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;


public class TreeSolution {
    public TreeSolution() {
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preOrderList = Arrays.stream(preorder).boxed().toList();
        List<Integer> inOrderList = Arrays.stream(inorder).boxed().toList();

        return buildTreeHelper(preOrderList, inOrderList);
    }

    private TreeNode buildTreeHelper(List<Integer> currentTreePreorder, List<Integer> currentTreeInorder) {
        if(currentTreePreorder.size() == 1 && currentTreeInorder.size() == 1) {
            return new TreeNode(currentTreePreorder.get(0), null, null);
        }
        if (currentTreePreorder.size() == 0 && currentTreeInorder.size() == 0) {
            return null;
        }
        TreeNode leftTree;
        TreeNode rightTree;
        int root = currentTreePreorder.get(0);
        int rootIndexInorder = currentTreeInorder.indexOf(root);
        List<Integer> leftTreeItemsInorder = currentTreeInorder.subList(0, rootIndexInorder);
        List<Integer> rightTreeItemsInorder = currentTreeInorder.subList(rootIndexInorder + 1, currentTreeInorder.size());
        List<Integer> leftTreeItemsPreorder = currentTreePreorder.subList(1, 1 + leftTreeItemsInorder.size());
        List<Integer> rightTreeItemsPreorder = currentTreePreorder.subList(1 + leftTreeItemsInorder.size(), currentTreeInorder.size());
        leftTree = buildTreeHelper(leftTreeItemsPreorder, leftTreeItemsInorder);
        rightTree = buildTreeHelper(rightTreeItemsPreorder, rightTreeItemsInorder);

        TreeNode currentTree = new TreeNode(root, leftTree, rightTree);
        return currentTree;
    }


    private HashSet<Integer> otherMax = new HashSet<>();
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int leftMax = maxPathSumWithRootAsEnd(root.left);
        int rightMax = maxPathSumWithRootAsEnd(root.right);
        int maxPathRoot;

        HashSet<Integer> maxSum = new HashSet<>();
        maxSum.add(root.val);
        maxSum.add(leftMax);
        maxSum.add(rightMax);
        maxSum.add(root.val + leftMax);
        maxSum.add(root.val + rightMax);
        maxSum.add(root.val + leftMax + rightMax);
        if (!otherMax.isEmpty()) {
            maxSum.addAll(otherMax);
        }
        return maxSum.stream().max(Integer::compareTo).get();
    }
    private int maxPathSumWithRootAsEnd(TreeNode tree) {
        if (tree == null) {
            return -9999;
        }
        if (tree.left == null && tree.right == null) {
            return tree.val;
        }

        int leftMax = maxPathSumWithRootAsEnd(tree.left);
        int rightMax = maxPathSumWithRootAsEnd(tree.right);
        otherMax.add(tree.val + leftMax + rightMax);
        int subResult = Math.max(Math.max(tree.val + leftMax,
                        tree.val + rightMax),
                tree.val);
        otherMax.add(subResult);
        return subResult;
    }

}
