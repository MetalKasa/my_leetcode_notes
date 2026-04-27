package com.mypractice.leetcode;

import java.util.*;

public class BacktrackingSolution {
    public BacktrackingSolution() {
    }

    /**
     * leetcode 17
     */
    public List<String> letterCombinations(String digits) {
        HashMap<String, List<String>> digitsLetterMap = new HashMap<>();
        digitsLetterMap.put("2", List.of("a", "b", "c"));
        digitsLetterMap.put("3", List.of("d", "e", "f"));
        digitsLetterMap.put("4", List.of("g", "h", "i"));
        digitsLetterMap.put("5", List.of("j", "k", "l"));
        digitsLetterMap.put("6", List.of("m", "n", "o"));
        digitsLetterMap.put("7", List.of("p", "q", "r", "s"));
        digitsLetterMap.put("8", List.of("t", "u", "v"));
        digitsLetterMap.put("9", List.of("w", "x", "y", "z"));

        List<String> result = letterCombinationsBacktracking(digitsLetterMap, digits, "", new ArrayList<>());
        return result;
    }

    private List<String> letterCombinationsBacktracking(HashMap<String, List<String>> digitsLetterMap, String digitsLeft, String currentString, List<String> allResults) {
        if (Objects.equals(digitsLeft, "") || digitsLeft.isEmpty()) {
            allResults.add(currentString);
            return allResults;
        }
        List<String> firstLetters = digitsLetterMap.get(digitsLeft.substring(0, 1));
        for (String firstLetter : firstLetters) {
            String newCurrentString = currentString + firstLetter;
            allResults = letterCombinationsBacktracking(digitsLetterMap, digitsLeft.substring(1, digitsLeft.length()), newCurrentString, allResults);
        }
        return allResults;
    }

    /**
     * leetcode 39
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        candidates = Arrays.stream(candidates).sorted().toArray();
        Set<List<Integer>> result = combinationSumBacktracking(candidates, target, 0, new ArrayList<>(), new HashSet<>());
        return result.stream().toList();
    }

    private Set<List<Integer>> combinationSumBacktracking(int[] candidates, int target, int currentSum, List<Integer> currentItems, Set<List<Integer>> results) {
        if (currentSum == target) {
            results.add(currentItems);
            return results;
        } else {
            for (int candidate : candidates) {
                if (currentSum + candidate > target) {
                    return results;
                }
                int tempCurrentSum = currentSum + candidate;
                List<Integer> tempCurrentItems = new ArrayList<>();
                tempCurrentItems.addAll(currentItems);
                tempCurrentItems.add(candidate);
                tempCurrentItems.sort(Integer::compareTo);
                results = combinationSumBacktracking(candidates, target, tempCurrentSum, tempCurrentItems, results);

            }
            return results;
        }
    }

    /**
     * leetcode 40
     * 和39的区别是candidates里的每个数只能用一次
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> candidateList = Arrays.stream(candidates).boxed().toList();
        Set<List<Integer>> resultSet =  combinationSum2Backtracking(candidateList, target, new ArrayList<>(), new HashSet<>());
        return resultSet.stream().toList();
    }

    private Set<List<Integer>> combinationSum2Backtracking(List<Integer> candidatesLeft, int targetLeft, List<Integer> currentItems, Set<List<Integer>> results) {
        if (targetLeft == 0) {
            List<Integer> oneResult = new ArrayList<>();
            oneResult.addAll(currentItems);
            results.add(oneResult.stream().sorted().toList());
            return results;
        }

        for (int i = 0; i < candidatesLeft.size(); i++) {
            int candidates = candidatesLeft.get(i);
            // 如果当前要试的数和上一个一样，那么不用试了
            if (i > 0 && candidates == candidatesLeft.get(i-1)) {
                continue;
            }
            if (candidates <= targetLeft) {
                targetLeft -= candidates;
                currentItems.add(candidates);
                // 小于i的都在前面的loop里试过了，剪枝
                List<Integer> newCandidatesLeft = new ArrayList<>(candidatesLeft.subList(i+1, candidatesLeft.size()));
                results = combinationSum2Backtracking(newCandidatesLeft, targetLeft,
                        currentItems, results);
                targetLeft += candidates;
                currentItems.remove(currentItems.size()-1);
                newCandidatesLeft.clear();
            }
        }
        return results;
    }

    /**
     * leetcode 77
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nList.add(i);
        }

        List<List<Integer>> result = combineBacktracking(nList, k, new ArrayList<>(), new ArrayList<>());
        return result;
    }

    private List<List<Integer>> combineBacktracking(List<Integer> currentNList, int currentK, List<Integer> currentCombination, List<List<Integer>> currentResult) {
        if (currentK == 0) {
            currentResult.add(currentCombination);
            return currentResult;
        }

        for (int i = 0; i < currentNList.size(); i++) {
            List<Integer> tempCurrentCombination = new ArrayList<>(currentCombination);
            tempCurrentCombination.add(currentNList.get(i));
            List<Integer> tempCurrentNList = currentNList.subList(i + 1, currentNList.size());
            currentResult = combineBacktracking(tempCurrentNList, currentK - 1, tempCurrentCombination, currentResult);
        }
        return currentResult;
    }

    /**
     * 78
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        if (numsList.size() == 0) {
            return List.of(new ArrayList<>());
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        return subsetBacktracking(numsList, result, new ArrayList<>());
    }

    private List<List<Integer>>  subsetBacktracking(List<Integer> currentNumsList, List<List<Integer>> currentResult, List<Integer> currentSubset) {
        for (int i = 0; i < currentNumsList.size(); i++) {
            List<Integer> tempCurrentSubset = new ArrayList<>(currentSubset);
            tempCurrentSubset.add(currentNumsList.get(i));
            currentResult.add(tempCurrentSubset);
            List<Integer> tempCurrentNumsList = currentNumsList.subList(i + 1, currentNumsList.size());
            currentResult = subsetBacktracking(tempCurrentNumsList, currentResult, tempCurrentSubset);
        }
        return currentResult;
    }
}
