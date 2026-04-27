package test.leetcode;

import com.mypractice.leetcode.TreeSolution;
import com.mypractice.module.TreeNode;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest
public class TreeSolutionTest {
    TreeSolution instance = new TreeSolution();

    // Helper method to print tree in level order for verification
    private String treeToString(TreeNode root) {
        if (root == null) return "[]";

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // Remove trailing nulls
        while (result.size() > 0 && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        return result.toString();
    }

    @Test
    public void buildTreeTest() {
        // Test case 1: Normal binary tree
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode tree1 = instance.buildTree(preorder1, inorder1);
        System.out.println("Test 1 - Tree structure: " + treeToString(tree1));

        // Test case 2: Single node tree
        int[] preorder2 = {1};
        int[] inorder2 = {1};
        TreeNode tree2 = instance.buildTree(preorder2, inorder2);
        System.out.println("Test 2 - Single node: " + treeToString(tree2));

        // Test case 3: Left-skewed tree
        int[] preorder3 = {3, 2, 1};
        int[] inorder3 = {1, 2, 3};
        TreeNode tree3 = instance.buildTree(preorder3, inorder3);
        System.out.println("Test 3 - Left-skewed: " + treeToString(tree3));

        // Test case 4: Right-skewed tree
        int[] preorder4 = {1, 2, 3};
        int[] inorder4 = {1, 2, 3};
        TreeNode tree4 = instance.buildTree(preorder4, inorder4);
        System.out.println("Test 4 - Right-skewed: " + treeToString(tree4));

        // Test case 5: Empty tree
        int[] preorder5 = {};
        int[] inorder5 = {};
        TreeNode tree5 = instance.buildTree(preorder5, inorder5);
        System.out.println("Test 5 - Empty tree: " + treeToString(tree5));

        // Test case 6: Complete binary tree
        int[] preorder6 = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder6 = {4, 2, 5, 1, 6, 3, 7};
        TreeNode tree6 = instance.buildTree(preorder6, inorder6);
        System.out.println("Test 6 - Complete binary tree: " + treeToString(tree6));
    }
}