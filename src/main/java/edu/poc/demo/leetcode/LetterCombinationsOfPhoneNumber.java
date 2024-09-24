package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

  private static Map<Character, String> map =
      Map.of(
          '2', "abc",
          '3', "def",
          '4', "ghi",
          '5', "jkl",
          '6', "mno",
          '7', "pqrs",
          '8', "tuv",
          '9', "wxyz");

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(() -> letterCombinations("45"));
  }

  static List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) return Collections.emptyList();

    List<String> output = new ArrayList<>();
    backtrack(0, new StringBuilder(), digits, output);
    return output;
  }

  static void backtrack(int index, StringBuilder sb, String digits, List<String> output) {
    if (index == digits.length()) {
      output.add(sb.toString());
      return;
    }
    String possiblePermutations = map.get(digits.charAt(index));
    for (int i = 0; i < possiblePermutations.length(); i++) {
      sb.append(possiblePermutations.charAt(i));
      backtrack(index + 1, sb, digits, output);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
