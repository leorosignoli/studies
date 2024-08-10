package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 959. Regions Cut By Slashes Medium
 *
 * <p>An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or
 * blank space ' '. These characters divide the square into contiguous regions.
 *
 * <p>Given the grid grid represented as a string array, return the number of regions.
 *
 * <p>Note that backslash characters are escaped, so a '\' is represented as '\\'.
 *
 * <p>Example 1:
 *
 * <p>Input: grid = [" /","/ "] Output: 2 Example 2:
 *
 * <p>Input: grid = [" /"," "] Output: 1 Example 3:
 *
 * <p>Input: grid = ["/\\","\\/"] Output: 5 Explanation: Recall that because \ characters are
 * escaped, "\\/" refers to \/, and "/\\" refers to /\.
 *
 * <p>Constraints:
 *
 * <p>n == grid.length == grid[i].length 1 <= n <= 30 grid[i][j] is either '/', '\', or ' '.
 */
public class RegionCutBySlashes {

  private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private static final int CELL_SIZE = 3;

  public static void main(String[] args) {

    ExecutionMeasure.measureExecutionTime(() -> regionsBySlashes(new String[] {" /", "/ "}));
  }

  public static int regionsBySlashes(String[] grid) {

    int gridSize = grid.length;
    int[][] expandedGrid = new int[gridSize * CELL_SIZE][gridSize * CELL_SIZE];

    // Populate the expanded grid based on the original grid
    for (int i = 0; i < gridSize; i++) {
      for (int j = 0; j < gridSize; j++) {
        int baseRow = i * CELL_SIZE;
        int baseCol = j * CELL_SIZE;
        char currentChar = grid[i].charAt(j);
        switch (currentChar) {
          case '\\':
            markBackslash(expandedGrid, baseRow, baseCol);
            break;
          case '/':
            markSlash(expandedGrid, baseRow, baseCol);
            break;
          default:
            break;
        }
      }
    }

    return countRegions(expandedGrid);
  }

  private static void markBackslash(int[][] expandedGrid, int baseRow, int baseCol) {
    expandedGrid[baseRow][baseCol] = 1;
    expandedGrid[baseRow + 1][baseCol + 1] = 1;
    expandedGrid[baseRow + 2][baseCol + 2] = 1;
  }

  private static void markSlash(int[][] expandedGrid, int baseRow, int baseCol) {
    expandedGrid[baseRow][baseCol + 2] = 1;
    expandedGrid[baseRow + 1][baseCol + 1] = 1;
    expandedGrid[baseRow + 2][baseCol] = 1;
  }

  private static int countRegions(int[][] expandedGrid) {
    return (int)
        IntStream.range(0, expandedGrid.length)
            .flatMap(
                i ->
                    IntStream.range(0, expandedGrid[i].length)
                        .filter(j -> expandedGrid[i][j] == 0)
                        .map(
                            j -> {
                              floodFill(expandedGrid, i, j);
                              return 1;
                            }))
            .count();
  }

  private static void floodFill(int[][] expandedGrid, int row, int col) {
    Queue<int[]> queue = new LinkedList<>();
    expandedGrid[row][col] = 1;
    queue.add(new int[] {row, col});

    while (!queue.isEmpty()) {
      int[] currentCell = queue.poll();
      for (int[] direction : DIRECTIONS) {
        int newRow = direction[0] + currentCell[0];
        int newCol = direction[1] + currentCell[1];
        if (isValidCell(expandedGrid, newRow, newCol)) {
          expandedGrid[newRow][newCol] = 1;
          queue.add(new int[] {newRow, newCol});
        }
      }
    }
  }

  private static boolean isValidCell(int[][] expandedGrid, int row, int col) {
    int n = expandedGrid.length;
    return row >= 0 && col >= 0 && row < n && col < n && expandedGrid[row][col] == 0;
  }
}
