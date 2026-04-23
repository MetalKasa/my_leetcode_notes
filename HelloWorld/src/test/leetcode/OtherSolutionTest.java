package test.leetcode;

import com.mypractice.leetcode.OtherSolution;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OtherSolutionTest {
    OtherSolution otherSolution = new OtherSolution();
    @Test
    public void findMedianSortedArraysTest() {

        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double result = otherSolution.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
