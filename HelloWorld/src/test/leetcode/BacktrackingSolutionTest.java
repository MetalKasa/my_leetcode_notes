package test.leetcode;

import com.mypractice.leetcode.BacktrackingSolution;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BacktrackingSolutionTest {
    BacktrackingSolution backtrackingSolution = new BacktrackingSolution();
    @Test
    public void combinationSumTest() {
        int[] testset1 = new int[] {2,3,6,7};
        int target1 = 7;
        List<List<Integer>> result = backtrackingSolution.combinationSum(testset1, target1);
        System.out.println(result);

        int[] testset2 = new int[] {8,7,4,3};
        int target2 = 11;
        System.out.println(backtrackingSolution.combinationSum(testset2, target2));
    }

    @Test
    public void combinationSum2Test() {

        int[] testset1 = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target1 = 30;
        List<List<Integer>> result = backtrackingSolution.combinationSum2(testset1, target1);
        System.out.println(result);

        int[] testset2 = new int[] {10,1,2,7,6,1,5};
        int target2 = 8;
        System.out.println(backtrackingSolution.combinationSum2(testset2, target2));
    }
}
