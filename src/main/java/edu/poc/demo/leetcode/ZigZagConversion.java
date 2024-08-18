package edu.poc.demo.leetcode;

/**
 * 6. Zigzag Conversion Solved Medium
 *
 * <p>Topics Companies The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * <p>P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 *
 * <p>Write the code that will take a string and make this conversion given a number of rows:
 *
 * <p>string convert(string s, int numRows);
 *
 * <p>Example 1:
 *
 * <p>Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR" Example 2:
 *
 * <p>Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI" Explanation: P I N A L S I G
 * Y A H R P I Example 3:
 *
 * <p>Input: s = "A", numRows = 1 Output: "A"
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length <= 1000 s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class ZigZagConversion {

  String convert(String s, int numRows) {

    if (numRows == 1 || s.length() <= numRows) {
      return s;
    }

    Character[][] chars = new Character[numRows][s.length()];
    int currentRow = 0;
    int col = 0;
    boolean isDescending = true;
    for (int i = 0; i < s.length(); i++) {
      chars[currentRow][col] = s.charAt(i);
      if (isDescending) {
        if (currentRow < numRows - 1) {
          currentRow++;
        } else {
          isDescending = false;
          currentRow--;
          col++;
        }
      } else {
        if (currentRow > 0) {
          currentRow--;
          col++;
        } else {
          isDescending = true;
          currentRow++;
        }
      }
    }

    StringBuilder res = new StringBuilder();
    for (int j = 0; j < chars.length; j++) {
      for (int k = 0; k < chars[j].length; k++) {
        if (chars[j][k] != null) res.append(chars[j][k]);
      }
    }

    return res.toString();
  }
}
