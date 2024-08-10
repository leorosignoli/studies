package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands Solved Medium
 *
 * <p>Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * <p>An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * <p>Example 1:
 *
 * <p>Input: grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"], ["1","1","0","0","0"],
 * ["0","0","0","0","0"] ] Output: 1 Example 2:
 *
 * <p>Input: grid = [ ["1","1","0","0","0"], ["1","1","0","0","0"], ["0","0","1","0","0"],
 * ["0","0","0","1","1"] ] Output: 3
 *
 * <p>Constraints:
 *
 * <p>m == grid.length n == grid[i].length 1 <= m, n <= 300 grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () ->
            new NumberOfIslands()
                .numIslands(
                    new char[][] {
                      {'1', '1', '1', '1', '0'},
                      {'1', '1', '0', '1', '0'},
                      {'1', '1', '0', '0', '0'},
                      {'0', '0', '0', '0', '0'}
                    }));
  }

  private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  private int numIslands(char[][] grid) {

    int totalIslands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == '1') {
          checkSurroundings(grid, i, j);
          totalIslands++;
        }
      }
    }
    return totalIslands;
  }

  private static void checkSurroundings(char[][] grid, int row, int collumn) {
    int colSize = grid[0].length;
    int rowSize = grid.length;
    Queue<int[]> unvisitedNodes = new LinkedList<>();
    grid[row][collumn] = 'V';
    unvisitedNodes.add(new int[] {row, collumn});

    while (!unvisitedNodes.isEmpty()) {
      int[] currentCell = unvisitedNodes.poll();
      for (int[] dir : DIRECTIONS) {
        int adjRow = currentCell[0] + dir[0];
        int adjCol = currentCell[1] + dir[1];
        if (adjRow >= 0
            && adjCol >= 0
            && adjRow < rowSize
            && adjCol < colSize
            && grid[adjRow][adjCol] == '1') {
          unvisitedNodes.add(new int[] {adjRow, adjCol});
          grid[adjRow][adjCol] = 'V';
        }
      }
    }
  }
}
