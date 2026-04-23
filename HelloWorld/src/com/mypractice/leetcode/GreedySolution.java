package com.mypractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreedySolution {

    /**
     * leetcode 11
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return maxArea;
    }

    /**
     * leetcode 44 没做出来
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (!p.contains("?") && !p.contains("*")) {
            return s.equals(p);
        }

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        int sIndex = 0;
        int pIndex = 0;
        int sIndexForStar = -1;
        int pIndexForStar = -1;
        while (sIndex < s.length()) {
            char sChar = sCharArray[sIndex];
            if (pIndex >= pCharArray.length) {
                // s还没结束但是p结束了，说明匹配错了，有*则回溯到*，没*就false
                if (sIndexForStar > -1) {
                    sIndexForStar++;
                    sIndex = sIndexForStar;
                    pIndex = pIndexForStar;
                    continue;
                } else {
                    return false;
                }
            }
            char pChar = pCharArray[pIndex];
            if (sChar == pChar) {
                sIndex++;
                pIndex++;
            } else if (pChar == '?') {
                sIndex++;
                pIndex++;
            } else if (pChar == '*') {
                pIndex++;
                pIndexForStar = pIndex;
                sIndexForStar = sIndex;
            } else if (sIndexForStar > -1) {
                // 啥都没匹配上，但是之前遇到了一个*，重新回到start的位置，s的start标记往后一位
                sIndexForStar++;
                sIndex = sIndexForStar;
                pIndex = pIndexForStar;
            } else {
                return false;
            }
        }
        while(pIndex < pCharArray.length) {
            if(pCharArray[pIndex] != '*') {
                return false;
            }
        }
        return true;
    }

    /**
     * leetcode 45
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        List<Integer> numMaxPosition = new ArrayList<>();
        for (int i = 0; i < numsList.size() - 1; i++) {
            // 每个item可以跳到的最远的index
            numMaxPosition.add(i + numsList.get(i));
        }
        numMaxPosition.add(0);

        int jumpCount = 0;
        int currentPosition = 0;
        int targetIndex = numsList.size() - 1;

        while (currentPosition < targetIndex) {
            if (numMaxPosition.get(currentPosition) >= targetIndex) {
                jumpCount++;
                return jumpCount;
            }
            // 找到当前位置能跳的目标点里，分别能跳到的最远距离
            List<Integer> jumpRange = numMaxPosition.subList(currentPosition, currentPosition + numsList.get(currentPosition) + 1);
            // 找到下一跳最远的目标点
            int maxNext = jumpRange.stream().max(Integer::compareTo).get();
            // 这个目标点就是下一跳了
            currentPosition = currentPosition + jumpRange.lastIndexOf(maxNext);
            jumpCount++;
        }
        return jumpCount;
    }

    /**
     * 55
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        List<Integer> numMaxPosition = new ArrayList<>();
        for (int i = 0; i < numsList.size() - 1; i++) {
            // 每个item可以跳到的最远的index
            numMaxPosition.add(i + numsList.get(i));
        }
        numMaxPosition.add(0);
        int currentPosition = 0;
        int targetIndex = numsList.size() - 1;

        while (currentPosition < targetIndex) {
            if (numsList.get(currentPosition) == 0) {
                return false;
            }
            if (numMaxPosition.get(currentPosition) >= targetIndex) {
                return true;
            }
            // 找到当前位置能跳的目标点里，分别能跳到的最远距离
            List<Integer> jumpRange = numMaxPosition.subList(currentPosition, currentPosition + numsList.get(currentPosition) + 1);
            // 找到下一跳最远的目标点
            int maxNext = jumpRange.stream().max(Integer::compareTo).get();
            // 这个目标点就是下一跳了
            currentPosition = currentPosition + jumpRange.lastIndexOf(maxNext);
        }
        return true;
    }

    /**
     * leetcode 122
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        List<Integer> profits = new ArrayList<>();
        for (int i = 1; i < prices.length; i++) {
            profits.add(Math.max(0, prices[i]-prices[i-1]));
        }
        return profits.stream().reduce(Integer::sum).get();
    }

    /**
     * leetcode 134
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n==1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }

        List<Integer> gasLeft = new ArrayList<>();
        List<Integer> gasDiff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 计算每一步的净油耗
            gasLeft.add(gas[i] - cost[i]);
        }
        if (gasLeft.stream().reduce(Integer::sum).get() < 0) {
            // 净油耗加起来到不了0肯定没戏
            return -1;
        }

        // 找可能的出发点
        List<Integer> potentialStartPoint = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int diff = (gasLeft.get(i) - gasLeft.get((i + n - 1) % n));
            // diff可以帮忙找到净油耗为正数的段落的起始位，比如净油耗 -2，3，4，3那我肯定从第一个3出发，-3 4 -3 我考虑从4出发
            // -3 -2 -1 的diff也是正的，但是净油耗是负的，排除
            if (diff > 0 && gasLeft.get(i) > 0) {
                potentialStartPoint.add(i);
            }
            gasDiff.add(diff);
        }

        // 然后就开始一个个看哪个点可以完成了
        boolean flag = true;
        for (Integer startIndex : potentialStartPoint) {
            int currentGas = gasLeft.get(startIndex);
            for (int i = 0; i < n; i++) {
                int nextIndex = (startIndex + 1 + i) % n;
                currentGas += gasLeft.get(nextIndex);
                if (currentGas < 0) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) return startIndex;
        }
        return -1;
    }
}
