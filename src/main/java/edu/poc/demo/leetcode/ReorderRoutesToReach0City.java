package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
1466. Reorder Routes to Make All Paths Lead to the City Zero
Solved
Medium

Topics
Companies

Hint
There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.



Example 1:


Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:


Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0


Constraints:

2 <= n <= 5 * 104
connections.length == n - 1
connections[i].length == 2
0 <= ai, bi <= n - 1
ai != bi
 */

public class ReorderRoutesToReach0City {

  public static void main(String[] args) {
    int n = 6;
    int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
    ExecutionMeasure.measureExecutionTime(() -> minReorder(n, connections));
  }

  static int minReorder(int n, int[][] connections) {
    // Array to keep track of visited cities
    // Array to keep track of visited cities
    final boolean[] visitedCities = new boolean[n];
    // Adjacency list to represent the graph
    final List<Integer>[] adjacencyList = new List[n];

    // Populate the adjacency list with connections
    for (int[] connection : connections) {
      final List<Integer> forwardList = getOrCreateList(adjacencyList, connection[0]);
      final List<Integer> reverseList = getOrCreateList(adjacencyList, connection[1]);

      // Add the forward direction
      forwardList.add(connection[1]);
      // Add the reverse direction (negated to distinguish)
      reverseList.add(-1 * connection[0]);
    }

    int reorderCount = 0;

    // Queue for BFS traversal
    final Queue<Integer> cityQueue = new LinkedList<>();
    cityQueue.add(0);

    while (!cityQueue.isEmpty()) {
      int currentCity = cityQueue.poll();

      // If the city is part of a reverse mapping, it leads to city 0
      if (currentCity <= 0) {
        currentCity *= -1;
      } else if (!visitedCities[currentCity]) {
        // If it's a forward mapping to an unvisited city, we need to reverse this route
        reorderCount++;
      }

      // Mark the city as visited and add its neighbors to the queue
      if (!visitedCities[currentCity]) {
        visitedCities[currentCity] = true;
        cityQueue.addAll(adjacencyList[currentCity]);
      }
    }

    return reorderCount;
  }

  // Helper method to get or create the adjacency list for a city
  private static List<Integer> getOrCreateList(List<Integer>[] adjacencyList, int cityIndex) {
    final var list =
        adjacencyList[cityIndex] == null ? new ArrayList<Integer>(2) : adjacencyList[cityIndex];
    return adjacencyList[cityIndex] = list;
  }
}
