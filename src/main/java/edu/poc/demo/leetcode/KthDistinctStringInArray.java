package edu.poc.demo.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class KthDistinctStringInArray {

  public static void main(String[] args) {
    String[] arr = {"a", "b", "c", "a", "b", "c", "d"};
    System.out.println(kthDistinct(arr, 3));
  }

  public static String kthDistinct(String[] arr, int k) {

    LinkedHashMap<String, Boolean> map = new LinkedHashMap<>();
    // put values in map, use a boolean to determine if it is unique
    for (String str : arr) {
      if (map.containsKey(str)) {
        map.put(str, false);
      } else {
        map.put(str, true);
      }
    }

    // iterate through the map until k, counting only the values where the boolean is true

    int counter = 0;
    Set<Map.Entry<String, Boolean>> set = map.entrySet();

    for (Map.Entry<String, Boolean> entry : set) {

      if (entry.getValue()) {
        counter++;
        if (counter == k) {
          return entry.getKey();
        }
      }
    }

    return "";
  }
}
