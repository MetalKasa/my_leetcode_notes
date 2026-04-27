package test.leetcode;

import com.mypractice.leetcode.WindowSolution;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WindowSolutionTest {
    WindowSolution instance = new WindowSolution();

    @Test
    public void lengthOfLongestSubstringTest() {
        // Test case 1: Normal string with repeating characters
        String s1 = "abcabcbb";
        int result1 = instance.lengthOfLongestSubstring(s1);
        System.out.println("Test 1 - Input: \"" + s1 + "\", Result: " + result1 + " (Expected: 3)");

        // Test case 2: All unique characters
        String s2 = "abcde";
        int result2 = instance.lengthOfLongestSubstring(s2);
        System.out.println("Test 2 - Input: \"" + s2 + "\", Result: " + result2 + " (Expected: 5)");

        // Test case 3: All same characters
        String s3 = "bbbbb";
        int result3 = instance.lengthOfLongestSubstring(s3);
        System.out.println("Test 3 - Input: \"" + s3 + "\", Result: " + result3 + " (Expected: 1)");

        // Test case 4: Empty string
        String s4 = "";
        int result4 = instance.lengthOfLongestSubstring(s4);
        System.out.println("Test 4 - Input: \"" + s4 + "\", Result: " + result4 + " (Expected: 0)");

        // Test case 5: Single character
        String s5 = "a";
        int result5 = instance.lengthOfLongestSubstring(s5);
        System.out.println("Test 5 - Input: \"" + s5 + "\", Result: " + result5 + " (Expected: 1)");

        // Test case 6: String with spaces
        String s6 = "a b c a";
        int result6 = instance.lengthOfLongestSubstring(s6);
        System.out.println("Test 6 - Input: \"" + s6 + "\", Result: " + result6 + " (Expected: 5)");

        // Test case 7: String with special characters
        String s7 = "aab!@#$%^&*()";
        int result7 = instance.lengthOfLongestSubstring(s7);
        System.out.println("Test 7 - Input: \"" + s7 + "\", Result: " + result7 + " (Expected: 10)");

        // Test case 8: Longer substring at the end
        String s8 = "abcdd";
        int result8 = instance.lengthOfLongestSubstring(s8);
        System.out.println("Test 8 - Input: \"" + s8 + "\", Result: " + result8 + " (Expected: 4)");
    }
}
