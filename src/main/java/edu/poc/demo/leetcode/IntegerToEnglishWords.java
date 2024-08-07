package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.HashMap;
import java.util.Map;

/**
 * 273. Integer to English Words Hard
 *
 * <p>Hint Convert a non-negative integer num to its English words representation. Example 1:
 *
 * <p>Input: num = 123 Output: "One Hundred Twenty Three" Example 2:
 *
 * <p>Input: num = 12345 Output: "Twelve Thousand Three Hundred Forty Five" Example 3:
 *
 * <p>Input: num = 1234567 Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
 * Seven"
 */
public class IntegerToEnglishWords {
  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(() -> numberToWords(122334067));
  }

  private static Map<Integer, String> numberWords;
  private static Map<Integer, String> magnitudeMap;

  static {
    magnitudeMap = new HashMap<>();
    numberWords = new HashMap<>();
    magnitudeMap.put(0, "");
    magnitudeMap.put(1, "Thousand ");
    magnitudeMap.put(2, "Million ");
    magnitudeMap.put(3, "Billion ");

    numberWords.put(0, "");
    numberWords.put(1, "One ");
    numberWords.put(2, "Two ");
    numberWords.put(3, "Three ");
    numberWords.put(4, "Four ");
    numberWords.put(5, "Five ");
    numberWords.put(6, "Six ");
    numberWords.put(7, "Seven ");
    numberWords.put(8, "Eight ");
    numberWords.put(9, "Nine ");
    numberWords.put(10, "Ten ");
    numberWords.put(11, "Eleven ");
    numberWords.put(12, "Twelve ");
    numberWords.put(13, "Thirteen ");
    numberWords.put(14, "Fourteen ");
    numberWords.put(15, "Fifteen ");
    numberWords.put(16, "Sixteen ");
    numberWords.put(17, "Seventeen ");
    numberWords.put(18, "Eighteen ");
    numberWords.put(19, "Nineteen ");
    numberWords.put(20, "Twenty ");
    numberWords.put(30, "Thirty ");
    numberWords.put(40, "Forty ");
    numberWords.put(50, "Fifty ");
    numberWords.put(60, "Sixty ");
    numberWords.put(70, "Seventy ");
    numberWords.put(80, "Eighty ");
    numberWords.put(90, "Ninety ");
    numberWords.put(100, "Hundred ");
  }

  private static String numberToWords(int num) {

    if (num == 0) return "Zero";

    StringBuilder res = new StringBuilder();
    String str = String.valueOf(num);
    int iteration = 0;

    while (!str.isEmpty()) {
      if (str.length() >= 3) {
        String threeDigitStr = str.substring(str.length() - 3);
        int temp = Integer.parseInt(threeDigitStr);
        str = str.substring(0, str.length() - 3);
        res.insert(0, helper(temp, iteration++));
      } else {
        int temp = Integer.parseInt(str);
        res.insert(0, helper(temp, iteration++));
        break;
      }
    }

    return res.toString().trim();
  }

  static String helper(int num, int orderOfMagnitude) {
    StringBuilder builder = new StringBuilder();

    if (num == 0) return "";

    if (num % 100 < 20) {
      builder.append(numberWords.get(num % 100));
      num /= 100;
    } else {
      builder.append(numberWords.get(num % 10));
      num /= 10;
      builder.insert(0, numberWords.get(num % 10 * 10));
      num /= 10;
    }

    if (num > 0) {
      builder.insert(0, "Hundred ");
      builder.insert(0, numberWords.get(num));
    }

    builder.append(magnitudeMap.get(orderOfMagnitude));

    return builder.toString();
  }
}
