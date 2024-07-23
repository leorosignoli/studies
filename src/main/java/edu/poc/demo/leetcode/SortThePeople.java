package edu.poc.demo.leetcode;

import java.util.Arrays;

public class SortThePeople {

  public void arrayTest(String[] test) {
    System.out.println(test);
  }

  public static void main(String[] args) {

    System.out.println(
        Arrays.asList(
            sortPeople(new String[] {"Alex", "Charlie", "Michael"}, new int[] {3, 2, 1})));
  }

  public static String[] sortPeople(String[] names, int[] heights) {

    String[] sortedNames = new String[names.length];

    for (int i = 0; i < names.length; i++) {
      int pivot = heights[i];
      int sortedPos = getPosition(pivot, heights);

      sortedNames[sortedPos] = names[i];
    }

    return sortedNames;
  }

  static int getPosition(int currentHeight, int[] heights) {

    int pos = 0;
    for (int height : heights) {
      if (currentHeight > height) pos++;
    }
    return pos;
  }
}
