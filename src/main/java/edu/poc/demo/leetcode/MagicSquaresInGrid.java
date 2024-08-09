package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;
import java.util.HashSet;
import java.util.Set;

/**
 * 840. Magic Squares In Grid
 *
 * <p>Medium
 *
 * <p>A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each
 * row, column, and both diagonals all have the same sum.
 *
 * <p>Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?
 *
 * <p>Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up
 * to 15.
 */
public class MagicSquaresInGrid {
  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () -> numMagicSquaresInside(new int[][] {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
  }

  public static int numMagicSquaresInside(int[][] grid) {
    int res = 0;

    for (int i = 0; i + 2 < grid.length; i++) {
      for (int j = 0; j + 2 < grid[0].length; j++) {
        if (isMagicSquare(grid, i, j)) {
          res++;
        }
      }
    }

    return res;
  }

  private static boolean isMagicSquare(int[][] grid, int row, int col) {
    Set<Integer> occurrenceSet = new HashSet<>();

    // Check if all numbers from 1 to 9 are present
    for (int i = row; i <= row + 2; i++) {
      for (int j = col; j <= col + 2; j++) {
        int num = grid[i][j];
        if (num < 1 || num > 9 || !occurrenceSet.add(num)) {
          return false;
        }
      }
    }

    // Check the sums of rows, columns, and diagonals
    int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
    for (int i = 0; i < 3; i++) {
      if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum
          || grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != sum) {
        return false;
      }
    }

      return grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] == sum
              && grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] == sum;
  }
}
