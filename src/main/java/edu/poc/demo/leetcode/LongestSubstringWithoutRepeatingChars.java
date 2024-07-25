package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * <p>Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingChars {

  public static void main(String[] args) {

    var randomStr = RandomStringUtils.randomAlphabetic(100);
    ExecutionMeasure.measureExecutionTime(() -> optimized(randomStr));
    ExecutionMeasure.measureExecutionTime(() -> lengthOfLongestSubstring(randomStr));
  }

  private static int lengthOfLongestSubstring(String s) {
    int max = 0;

    for (int i = 0; i < s.length(); i++) {
      var subString = s.substring(i);
      Set<Character> chars = new HashSet<>();
      int temp = 0;
      for (char c : subString.toCharArray()) {

        if (chars.contains(c)) {
          break;
        }
        chars.add(c);
        temp++;

        max = Math.max(max, chars.size());
      }
    }

    return max;
  }

  private static int optimized(String s) {
    int n = s.length();
    int max = 0;
    int left = 0;
    HashMap<Character, Integer> charIndexMap = new HashMap<>();

    for (int right = 0; right < n; right++) {
      char c = s.charAt(right);

      if (charIndexMap.containsKey(c)) {
        left = Math.max(charIndexMap.get(c) + 1, left);
      }

      charIndexMap.put(c, right);
      max = Math.max(max, right - left + 1);
    }

    return max;
  }
}
