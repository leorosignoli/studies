package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 *
 * <p>There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi,
 * weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the
 * integer distanceThreshold.
 *
 * <p>Return the city with the smallest number of cities that are reachable through some path and
 * whose distance is at most distanceThreshold, If there are multiple such cities, return the city
 * with the greatest number.
 *
 * <p>Notice that the distance of a path connecting cities i and j is equal to the sum of the edges'
 * weights along that path.
 *
 * <p>Example 1:
 *
 * <p>Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4 Output: 3
 * Explanation: The figure above describes the graph. The neighboring cities at a distanceThreshold
 * = 4 for each city are: City 0 -> [City 1, City 2] City 1 -> [City 0, City 2, City 3] City 2 ->
 * [City 0, City 1, City 3] City 3 -> [City 1, City 2] Cities 0 and 3 have 2 neighboring cities at a
 * distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
 */
public class SmallestNofNeighborsAtThresholdDistance {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () -> {
          int n = 5;
          int[][] edges = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
          int distanceThreshold = 2;
          return findTheCity(n, edges, distanceThreshold);
        });
  }

  private static int findTheCity(int n, int[][] edges, int distanceThreshold) {

    List<int[]>[] adjacencyList = new List[n];

    int[][] costMatrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {

        costMatrix[i][j] = Integer.MAX_VALUE;
      }
      costMatrix[i][i] = 0;
      adjacencyList[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      int start = edge[0];
      int end = edge[1];
      int distance = edge[2];
      adjacencyList[start].add(new int[] {end, distance});
      adjacencyList[end].add(new int[] {start, distance});
    }

    for (int city = 0; city < n; city++) {
      dijkstra(n, adjacencyList, costMatrix[city], city);
    }

    return getCityWithFewestReachable(n, costMatrix, distanceThreshold);
  }

  private static void dijkstra(
      int n, List<int[]>[] adjacencyList, int[] shortestPathDistances, int source) {
    // Priority queue to process nodes with the smallest distance first
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
    priorityQueue.add(new int[] {source, 0});
    Arrays.fill(shortestPathDistances, Integer.MAX_VALUE); // Set all distances to infinity
    shortestPathDistances[source] = 0; // Distance to source itself is zero

    // Process nodes in priority order
    while (!priorityQueue.isEmpty()) {
      int[] current = priorityQueue.remove();
      int currentCity = current[0];
      int currentDistance = current[1];
      if (currentDistance > shortestPathDistances[currentCity]) {
        continue;
      }

      // Update distances to neighboring cities
      for (int[] neighbor : adjacencyList[currentCity]) {
        int neighborCity = neighbor[0];
        int edgeWeight = neighbor[1];
        if (shortestPathDistances[neighborCity] > currentDistance + edgeWeight) {
          shortestPathDistances[neighborCity] = currentDistance + edgeWeight;
          priorityQueue.add(
              new int[] {
                neighborCity, shortestPathDistances[neighborCity],
              });
        }
      }
    }
  }

  // Determine the city with the fewest number of reachable cities within the distance threshold
  private static int getCityWithFewestReachable(
      int n, int[][] shortestPathMatrix, int distanceThreshold) {
    int cityWithFewestReachable = -1;
    int fewestReachableCount = n;

    // Count number of cities reachable within the distance threshold for each city
    for (int i = 0; i < n; i++) {
      int reachableCount = 0;
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        } // Skip self
        if (shortestPathMatrix[i][j] <= distanceThreshold) {
          reachableCount++;
        }
      }
      // Update the city with the fewest reachable cities
      if (reachableCount <= fewestReachableCount) {
        fewestReachableCount = reachableCount;
        cityWithFewestReachable = i;
      }
    }
    return cityWithFewestReachable;
  }
}
