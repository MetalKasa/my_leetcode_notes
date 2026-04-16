package com.mypractice.leetcode;

import java.util.*;

public class OtherSolution {
    public OtherSolution() {
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];

//        作者：力扣官方题解
//        链接：https://leetcode.cn/problems/edit-distance/solutions/188223/bian-ji-ju-chi-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public void rotate(int[][] matrix) {
        // 48 旋转图像
        int m = matrix.length;

        // 沿斜线翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i + j == m - 1) {
                    break;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-1-j][m-1-i];
                matrix[m-1-j][m-1-i] = temp;
            }
        }

        // 上下翻转
        for (int i = 0; i < (m +1) / 2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m-1-i][j];
                matrix[m-1-i][j] = temp;
            }
        }
    }

    public int longestPalindrome(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int count = 0;
        for(int i = 0; i < charArray.length; i++) {
            String key = String.valueOf(charArray[i]);
            map.computeIfAbsent(key, k -> 0);
            map.put(key, map.get(key)+1);
        }
        System.out.println(map);
        int hasOdd = 0;
        int length = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 != 0) {
                hasOdd = 1;
                length += (value - 1);
            } else {
                length += value;

            }
        }
        return length + hasOdd;
    }

    public int longestConsecutive(int[] nums) {
        int[] array = Arrays.stream(nums).sorted().toArray();
        System.out.println(array.toString());

        int tempresult = 1;
        int maxresult = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] + 1 == array[i]) {
                tempresult++;
            } else if (array[i-1] == array[i]) {
                continue;
            } else {
                maxresult =  Math.max(maxresult, tempresult);
                tempresult = 1;
            }
        }
        return Math.max(maxresult, tempresult);
    }


    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int numCount = 1;
        int currentNum = 2;
        int finalNum = 1;
        HashSet<Integer> historyUglyNum = new HashSet<>();
        historyUglyNum.add(1);
        while (numCount <= n) {
            if (historyUglyNum.contains(currentNum/2) || historyUglyNum.contains(currentNum/3)|| historyUglyNum.contains(currentNum/5)) {
                numCount++;
                finalNum = currentNum;
                historyUglyNum.add(currentNum);
            }
            currentNum++;
        }
        return finalNum;
    }
    

}