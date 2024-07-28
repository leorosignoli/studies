package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.HashMap;
import java.util.Map;

/**
 * 1791. Find Center of Star Graph
 *
 * <p>There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a
 * graph where there is one center node and exactly n - 1 edges that connect the center node with
 * every other node.
 *
 * <p>You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is
 * an edge between the nodes ui and vi. Return the center of the given star graph.
 */
public class CenterOfStarGraph {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        "own impl",
        () -> {
          int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
          return findCenter(edges);
        });
    ExecutionMeasure.measureExecutionTime(
        "editorial",
        () -> {
          int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
          return editorialFindCenter(edges);
        });
  }

  public static int findCenter(int[][] edges) {

    if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) return edges[0][0];

    return edges[0][1];
  }

  public static int editorialFindCenter(int[][] edges) {
    Map<Integer, Integer> degree = new HashMap<>();

    for (int[] edge : edges) {
      degree.put(edge[0], degree.getOrDefault(edge[0], 0) + 1);
      degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
    }

    for (int node : degree.keySet()) {
      if (degree.get(node) == edges.length) {
        return node;
      }
    }

    return -1;
  }
}
