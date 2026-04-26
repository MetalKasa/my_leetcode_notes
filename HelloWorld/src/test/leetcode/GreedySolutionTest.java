package test.leetcode;

import com.mypractice.leetcode.GreedySolution;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreedySolutionTest {
    GreedySolution greedySolution = new GreedySolution();

    @Test
    public void jumpTest() {
        int[] nums1 = new int[] {3,2,1};
        System.out.println(greedySolution.jump(nums1));

        int[] nums2 = new int[] {2,3,1,1,4};
        System.out.println(greedySolution.jump(nums2));

        int[] nums3 = new int[] {1, 1, 1, 1};
        System.out.println(greedySolution.jump(nums3));

        int[] nums4 = new int[] {1, 1, 1, 1, 1};
        System.out.println(greedySolution.jump(nums4));
    }

    @Test
    public void canCompleteCircuitTest() {
        int[] gas1 = new int[] {1,2,3,4,5};
        int[] cost1 = new int[] {3,4,5,1,2};
        System.out.println(greedySolution.canCompleteCircuit(gas1, cost1));
    }

    @Test
    public void largestNumber(){
        int[] input1 = new int[]{3,30,34,5,9};
        System.out.println(greedySolution.largestNumber(input1));
    }
}
