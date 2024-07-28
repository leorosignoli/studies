package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.Arrays;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 2864. Maximum Odd Binary Number
 *
 * <p>You have to rearrange the bits in such a way that the resulting binary number is the maximum
 * odd binary number that can be created from this combination.
 *
 * <p>Return a string representing the maximum odd binary number that can be created from the given
 * combination.
 *
 * <p>Note that the resulting string can have leading zeros.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "010" Output: "001" Explanation: Because there is just one '1', it must be in the
 * last position. So the answer is "001". Example 2:
 *
 * <p>Input: s = "0101" Output: "1001" Explanation: One of the '1's must be in the last position.
 * The maximum number that can be made with the remaining digits is "100". So the answer is "1001".
 */
public class MaximumOddBinaryNumber {

  private static final String TEST_STRING = RandomStringUtils.random(15, '0', '1');

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime("default\t\t", () -> maximumOddBinaryNumber(TEST_STRING));
    ExecutionMeasure.measureExecutionTime("alternative\t", () -> singleIteration(TEST_STRING));
  }

  private static String maximumOddBinaryNumber(String s) {

    // sort the array, takes O(n log(n))
    char[] str = s.toCharArray();
    Arrays.sort(str);

    for (int i = 0; i < (str.length - 1) / 2; i++) {
      char temp = str[i];
      str[i] = str[str.length - 2 - i];
      str[str.length - 2 - i] = temp;
    }
    return new String(str);
  }

  private static String singleIteration(String s) {
    int n = s.length();
    int oneCount = 0;

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        oneCount++;
      }
    }

    char[] result = new char[n];
    int index = 0;

    for (int i = 1; i < oneCount; i++) {
      result[index++] = '1';
    }
    for (int i = 0; i < s.length() - oneCount; i++) {
      result[index++] = '0';
    }

    // Add the first '1' at the end
    result[index] = '1';
    return new String(result);
  }
}
