package test.leetcode;

import com.mypractice.leetcode.OtherSolution;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;

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

    @Test
    public void removeDuplicatesTest() {
        // Test case 1: Array with duplicates
        int[] nums1 = {0,0,1,1,1,1,2,3,3};
        int k1 = otherSolution.removeDuplicates(nums1);
        System.out.println("Test 1 - Original: [0,0,1,1,1,1,2,3,3]");
        System.out.println("Test 1 - After removal (first " + k1 + " elements): " + Arrays.toString(Arrays.copyOf(nums1, k1)));
        System.out.println("Test 1 - Return value: " + k1 + " (Expected: 5)");
        System.out.println();

        // Test case 2: No duplicates
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = otherSolution.removeDuplicates(nums2);
        System.out.println("Test 2 - Original: [1,2,3,4,5]");
        System.out.println("Test 2 - After removal (first " + k2 + " elements): " + Arrays.toString(Arrays.copyOf(nums2, k2)));
        System.out.println("Test 2 - Return value: " + k2 + " (Expected: 5)");
        System.out.println();

        // Test case 3: All duplicates
        int[] nums3 = {1, 1, 1, 1, 1};
        int k3 = otherSolution.removeDuplicates(nums3);
        System.out.println("Test 3 - Original: [1,1,1,1,1]");
        System.out.println("Test 3 - After removal (first " + k3 + " elements): " + Arrays.toString(Arrays.copyOf(nums3, k3)));
        System.out.println("Test 3 - Return value: " + k3 + " (Expected: 1)");
        System.out.println();

        // Test case 4: Empty array
        int[] nums4 = {};
        int k4 = otherSolution.removeDuplicates(nums4);
        System.out.println("Test 4 - Original: []");
        System.out.println("Test 4 - After removal (first " + k4 + " elements): " + Arrays.toString(Arrays.copyOf(nums4, k4)));
        System.out.println("Test 4 - Return value: " + k4 + " (Expected: 0)");
        System.out.println();

        // Test case 5: Single element
        int[] nums5 = {7};
        int k5 = otherSolution.removeDuplicates(nums5);
        System.out.println("Test 5 - Original: [7]");
        System.out.println("Test 5 - After removal (first " + k5 + " elements): " + Arrays.toString(Arrays.copyOf(nums5, k5)));
        System.out.println("Test 5 - Return value: " + k5 + " (Expected: 1)");
        System.out.println();

        // Test case 6: Large values
        int[] nums6 = {-100, -100, 0, 0, 50, 100, 100};
        int k6 = otherSolution.removeDuplicates(nums6);
        System.out.println("Test 6 - Original: [-100,-100,0,0,50,100,100]");
        System.out.println("Test 6 - After removal (first " + k6 + " elements): " + Arrays.toString(Arrays.copyOf(nums6, k6)));
        System.out.println("Test 6 - Return value: " + k6 + " (Expected: 4)");
    }
}
