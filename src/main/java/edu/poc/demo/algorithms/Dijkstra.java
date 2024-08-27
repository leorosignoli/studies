package edu.poc.demo.algorithms;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Dijkstra's algorithm is an algorithm for finding the shortest paths between nodes in a graph, which may represent, for example, road networks.
 */
public class Dijkstra {
  /*
   * Main method to test the algorithm
   *
   */
  public static void main(String[] args) {
    // {source, destination, weight}
    // shortest path from 0 to 4 is 21
    int[][] graph =
        new int[][] {
          {0, 1, 4},
          {0, 7, 8},
          {1, 2, 8},
          {1, 7, 11},
          {2, 3, 7},
          {2, 8, 2},
          {2, 5, 4},
          {3, 4, 9},
          {3, 5, 14},
          {4, 5, 10},
          {5, 6, 2},
          {6, 7, 1},
          {6, 8, 6},
          {7, 8, 7}
        };
    ExecutionMeasure.measureExecutionTime("self implementation", () -> dijkstra(graph, 0, 4));
    ExecutionMeasure.measureExecutionTime(
        "copilot implementation", () -> aiGeneratedDijkstra(graph, 0, 4));
  }

  static int dijkstra(int[][] graph, int start, int end) {

    Map<Integer, Integer>[] adjacencyMap = new Map[graph.length];
    for (int i = 0; i < adjacencyMap.length; i++) {
      adjacencyMap[i] = new HashMap<>();
    }

    // build the adjacency map
    for (int[] connection : graph) {
      int source = connection[0];
      int dest = connection[1];
      int weight = connection[2];
      adjacencyMap[source].put(dest, weight);
      adjacencyMap[dest].put(source, weight);
    }

    // dijkstra's
    PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));

    int[] totalWeight = new int[adjacencyMap.length];
    Arrays.fill(totalWeight, Integer.MAX_VALUE);

    queue.offer(new Pair(start, 0));
    totalWeight[start] = 0;
    while (!queue.isEmpty()) {

      var currentNode = queue.poll();
      var currentNodeWeight = totalWeight[currentNode.node];
      if (currentNode.node == end) {
        return totalWeight[currentNode.node];
      }

      var destinations = adjacencyMap[currentNode.node];

      for (var destination : destinations.entrySet()) {
        var destinationWeight = destination.getValue();
        var destinationTarget = destination.getKey();
        var sumToDestination = currentNodeWeight + destinationWeight;
        if (sumToDestination < totalWeight[destinationTarget]) {
          totalWeight[destinationTarget] = sumToDestination;
          queue.offer(new Pair(destinationTarget, sumToDestination));
        }
      }
    }
    // in case it cant be found
    return -1;
  }

  static int aiGeneratedDijkstra(int[][] graph, int start, int end) {
    List<Map<Integer, Integer>> adjacencyList = buildAdjacencyList(graph);

    PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
    int[] totalWeight = new int[adjacencyList.size()];
    int[] previous = new int[adjacencyList.size()];
    Arrays.fill(totalWeight, Integer.MAX_VALUE);
    Arrays.fill(previous, -1);

    queue.offer(new Pair(start, 0));
    totalWeight[start] = 0;

    while (!queue.isEmpty()) {
      Pair currentNode = queue.poll();
      int currentNodeWeight = totalWeight[currentNode.node];
      if (currentNode.node == end) {
        return totalWeight[currentNode.node];
      }

      Map<Integer, Integer> destinations = adjacencyList.get(currentNode.node);
      for (Map.Entry<Integer, Integer> destination : destinations.entrySet()) {
        int destinationWeight = destination.getValue();
        int destinationTarget = destination.getKey();
        int sumToDestination = currentNodeWeight + destinationWeight;
        if (sumToDestination < totalWeight[destinationTarget]) {
          totalWeight[destinationTarget] = sumToDestination;
          previous[destinationTarget] = currentNode.node;
          queue.offer(new Pair(destinationTarget, sumToDestination));
        }
      }
    }
    return -1;
  }

  private static List<Map<Integer, Integer>> buildAdjacencyList(int[][] graph) {
    List<Map<Integer, Integer>> adjacencyList = new ArrayList<>();
    for (int i = 0; i < graph.length; i++) {
      adjacencyList.add(new HashMap<>());
    }

    for (int[] connection : graph) {
      int source = connection[0];
      int dest = connection[1];
      int weight = connection[2];
      adjacencyList.get(source).put(dest, weight);
      adjacencyList.get(dest).put(source, weight);
    }
    return adjacencyList;
  }

  private static class Pair {
    Integer node;
    Integer weight;

    Pair(int node, int weight) {
      this.node = node;
      this.weight = weight;
    }
  }
}
