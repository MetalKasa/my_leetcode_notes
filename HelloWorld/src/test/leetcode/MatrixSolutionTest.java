package test.leetcode;

import com.mypractice.leetcode.MatrixSolution;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;

@SpringBootTest
public class MatrixSolutionTest {

    MatrixSolution matrixSolution = new MatrixSolution();

    @Test
    public void setZeroesTest() {
        int[][] matrix = {{0, 1}};
        matrixSolution.setZeroes(matrix);
    }

    @Test
    public void searchMatrixTest() {
        // Test case 1: Target found in matrix
        int[][] matrix1 = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
        int target1 = 9;
        boolean result1 = matrixSolution.searchMatrix(matrix1, target1);
        System.out.println("Test 1 - Target " + target1 + " in matrix: " + result1);

        // Test case 2: Target not in matrix
        int[][] matrix2 = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
        int target2 = 8;
        boolean result2 = matrixSolution.searchMatrix(matrix2, target2);
        System.out.println("Test 2 - Target " + target2 + " in matrix: " + result2);

        // Test case 3: Target at beginning
        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}};
        int target3 = 1;
        boolean result3 = matrixSolution.searchMatrix(matrix3, target3);
        System.out.println("Test 3 - Target " + target3 + " at beginning: " + result3);

        // Test case 4: Single row matrix
        int[][] matrix4 = {{1, 2, 3, 4, 5}};
        int target4 = 3;
        boolean result4 = matrixSolution.searchMatrix(matrix4, target4);
        System.out.println("Test 4 - Single row, target " + target4 + ": " + result4);

        // Test case 5: Empty matrix
        int[][] matrix5 = {};
        int target5 = 5;
        try {
            boolean result5 = matrixSolution.searchMatrix(matrix5, target5);
            System.out.println("Test 5 - Empty matrix: " + result5);
        } catch (Exception e) {
            System.out.println("Test 5 - Empty matrix caused exception: " + e.getMessage());
        }
    }
}
