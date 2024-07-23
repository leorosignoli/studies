package edu.poc.demo.bigO;

// sort each string in the array and then sorts the array of strings itself
public class SortStringArray {

  // O(b * a log(a) + b log(b)) -> O( ab (log(a) + log(b)))
  // where a is the length of the string
  // and b is the length of the string array
  void sortStringsAndStringArray(String[] strings) {
    String[] sortedStrings = new String[strings.length];
    // O(a)
    for (int i = 0; i < strings.length; i++) {
      // O(a log(a))
      String sortedStr = quickSort(strings[i]);
      sortedStrings[i] = sortedStr;
    }
    // O(a * b log b)
    for (int i = 0; i < sortedStrings.length; i++) {
      sortedStrings = sortStringArray(sortedStrings);
    }
  }

  // O(n logn)
  private String[] sortStringArray(String[] sortedStrings) {
    return new String[1];
  }

  /*
  "sttet" -> "esttt"
  time complexity: O(a log a)
  */
  String quickSort(String str) {
    return "mock";
  }
}
