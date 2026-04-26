package test.leetcode;

import com.mypractice.leetcode.MatrixSolution;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MatrixSolutionTest {

    MatrixSolution matrixSolution = new MatrixSolution();
    @Test
    public void setZeroesTest() {
        int[][] matrix = {{0, 1}};
        matrixSolution.setZeroes(matrix);
    }
}
