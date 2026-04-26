package com.mypractice.leetcode;

import java.util.*;

public class MatrixSolution {
    /**
     * leetcode 73
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroColumn = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroColumn.add(j);
                }
            }
        }
        if(zeroRow.size() == n || zeroColumn.size() == m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] =0;
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (zeroRow.contains(i) || zeroColumn.contains(j)) {
                    matrix[i][j] =0;
                }
            }
        }
    }

    /**
     * leetcode 74
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (n == 1) {
            List<Integer> firstLine = Arrays.stream(matrix[0]).boxed().toList();
            return firstLine.contains(target);
        }

        int possibleLine = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if (target == matrix[i][0] || target == matrix[i+1][0]) {
                return true;
            }
            if (target > matrix[i][0] && target < matrix[i+1][0]) {
                possibleLine = i;
                break;
            }
        }

        for (int j = 0; j < m; j++) {
            if (target == matrix[possibleLine][j]) {
                return true;
            }
        }
        return false;
    }
}
