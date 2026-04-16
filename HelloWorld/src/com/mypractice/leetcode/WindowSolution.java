package com.mypractice.leetcode;

import java.util.*;

public class WindowSolution {
    public WindowSolution() {
    }

    /**
     * leetcode No.3
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int left = 0;
        int right = 1;
        int max = 1;
        while (right < s.length()) {
            String currentSubstring = s.substring(left, right);
            char currentChar = s.charAt(right);
            int currentCharIndex = currentSubstring.indexOf(currentChar);
            if (currentCharIndex != -1) {
                left = left + currentCharIndex + 1;
            }

            right++;
            max = Math.max(max, right-left);
        }
        return max;
    }

    /**
     * leetcode No.159
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        Set<Character> existingChars = new HashSet<>();

        int left = 0; int right = 1;
        existingChars.add(s.charAt(left));

        int max = 1;
        while (right < s.length()) {
            String currentSubstring = s.substring(left, right);
            char currentChar = s.charAt(right);
            if (existingChars.size() == 2 && !existingChars.contains(currentChar)) {
                char stayChar = s.charAt(right - 1);
                char removeChar = existingChars.stream().filter(c -> !c.equals(stayChar)).toList().get(0);
                existingChars.remove(removeChar);
                int lastIndexOfRemoveChar = currentSubstring.lastIndexOf(removeChar);
                left = left + lastIndexOfRemoveChar + 1;
            }
            existingChars.add(currentChar);
            right++;
            max = Math.max(max, right-left);
        }

        return max;
    }

    /**
     * leetcode 187
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }

        Map<String, Integer> substringOcc = new HashMap<>();
        Set<String> result = new HashSet<>();
        Set<String> existingSubstring = new HashSet<>();
        for(int i = 0; i < s.length()-10; i++) {
            String subString = s.substring(i, i + 10);
            if (existingSubstring.contains(subString)) {
                result.add(subString);
            }
            existingSubstring.add(subString);
        }
        return result.stream().toList();
    }

    /**
     * leetcode 209
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).sum() < target) {
            return 0;
        }

        int left = 0; int right = 1;
        int currentSum = nums[0];
        if (currentSum >= target) {
            return 1;
        }
        int minLength = Integer.MAX_VALUE;

        while (right < nums.length || left < nums.length) {
            if (currentSum >= target) {
                minLength = Math.min(minLength, right - left);
                currentSum -= nums[left];
                left++;
            } else {
                if  (right < nums.length) {
                    currentSum += nums[right];
                    right++;
                } else {
                    break;
                }
            }
        }
        return minLength;

    }
}
