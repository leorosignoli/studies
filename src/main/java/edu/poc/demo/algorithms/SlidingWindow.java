package edu.poc.demo.algorithms;

public class SlidingWindow {

  public static void main(String[] args) {
    int[] arr = {100, 200, 300, 400, 1000, 600, 700, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int[] arr2 = {200, 100, 300, 400, 1000, 600, 700, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int k = 2;
    // should be 2700
    System.out.println(maxSumFixedSlidingWindow(arr, 4));
    System.out.println(leftRightPointers(arr2));
    System.out.println(variableSizedSlidingWindow("cabbaacb"));
    System.out.println(variableSizedSlidingWindow("xlkasjhdHSUJKLSH;dddddddddddddai;lhjnslknm"));
  }

  /** Find biggest sum of k elements in an array */
  public static int maxSumFixedSlidingWindow(int[] arr, int k) {
    int maxSum = 0;

    for (int i = 0; i < k; i++) {
      maxSum += arr[i];
    }
    int currentSum = maxSum;
    for (int i = k; i < arr.length - k; i++) {
      currentSum += arr[i] - arr[i - k];
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }

  /** return the biggest length of increasing order integers */
  public static int leftRightPointers(int[] arr) {
    if (arr.length == 0) return 0;
    else if (arr.length < 2) return 1;

    int maxSize = 0;
    int currentSize = 0;
    for (int r = 1; r < arr.length; r++) {

      if (arr[r] > arr[r - 1]) {
        currentSize++;
      } else {
        currentSize = 1;
      }
      maxSize = Math.max(currentSize, maxSize);
    }
    return maxSize;
  }

  /** biggest substring Palindrome in String */
  public static int variableSizedSlidingWindow(String str) {
    if (str.length() == 1) return 1;
    int maxSize = 0;
    for (int i = 1; i < str.length(); i++) {

      String subStr = expandWhilePalindromic(str, i);

      maxSize = Math.max(maxSize, subStr.length());
    }

    return maxSize;
  }

  public static String expandWhilePalindromic(String str, int index) {
    int left = index - 1;
    int right = index + 1;
    String subStr = String.valueOf(str.charAt(index));
    while (left >= 0 && str.charAt(left) == str.charAt(index)) {
      subStr = str.substring(left--, index + 1);
    }
    while (right < str.length() && str.charAt(right) == str.charAt(index)) {
      subStr = str.substring(index, 1 + right++);
    }

    while (left >= 0 && right < str.length()) {
      if (str.charAt(left) == str.charAt(right)) subStr = str.substring(left--, 1 + right++);
      else break;
    }

    return subStr;
  }
}
