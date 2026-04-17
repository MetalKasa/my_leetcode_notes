package com.mypractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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

}
