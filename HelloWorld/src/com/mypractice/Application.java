package com.mypractice;

import com.mypractice.leetcode.BacktrackingSolution;
import com.mypractice.leetcode.TreeSolution;
import com.mypractice.leetcode.WindowSolution;
import com.mypractice.module.TreeNode;

public class Application {

    public static void main(String[] args) {
        TreeSolution solution = new TreeSolution();

//        int[] preorder = new int[]{1, 2};
//        int[] inorder = new int[]{2, 1};
//        solution.buildTree(preorder, inorder);

        // [-10,9,20,null,null,15,7]
//        TreeNode leftTree = new TreeNode(9);
//        TreeNode rightTree = new TreeNode(20, new TreeNode(15), new TreeNode(7));
//        TreeNode root = new TreeNode(-10, leftTree, rightTree);
//
//        // [-2 null -3]
//        TreeNode root2 = new TreeNode(-2, null, new TreeNode(-3));
//
//        int result = solution.maxPathSum(root2);
//        System.out.println(result);

//        WindowSolution windowSolution = new WindowSolution();
//        int[] test = new int[] {1,1,1,1,7};
//        System.out.println(windowSolution.minSubArrayLen(7, test));

        BacktrackingSolution backtrackingSolution = new BacktrackingSolution();
        System.out.println(backtrackingSolution.letterCombinations("23"));
    }
}
