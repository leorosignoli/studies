package edu.poc.demo.leetcode;

/**
 * 885. Spiral Matrix III Solved Medium
 *
 * <p>You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest
 * corner is at the first row and column in the grid, and the southeast corner is at the last row
 * and column.
 *
 * <p>You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you
 * move outside the grid's boundary, we continue our walk outside the grid (but may return to the
 * grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.
 *
 * <p>Return an array of coordinates representing the positions of the grid in the order you visited
 * them.
 *
 * <p>Example 1:
 *
 * <p>Input: rows = 1, cols = 4, rStart = 0, cStart = 0 Output: [[0,0],[0,1],[0,2],[0,3]] Example 2:
 *
 * <p>Input: rows = 5, cols = 6, rStart = 1, cStart = 4 Output:
 * [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 *
 * <p>Constraints:
 *
 * <p>1 <= rows, cols <= 100 0 <= rStart < rows 0 <= cStart < cols
 */
public class SpiralMatrixIII {

  public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    // Result array to store the coordinates in the order they are visited
    int[][] res = new int[rows * cols][2];

    // Initialize starting position
    int rPointer = rStart;
    int cPointer = cStart;

    // Counter to keep track of the number of cells visited
    int counter = 0;

    // Directions array: right, down, left, up
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // Index to keep track of the current direction
    int dirIndex = 0; // Start with the direction "right"

    // Number of steps to take in the current direction
    int steps = 1;

    // Add the starting position to the result array
    res[counter++] = new int[] {rPointer, cPointer};

    // Continue until all cells are visited
    while (counter < rows * cols) {
      // There are two turns for each step size (e.g., right and down, or left and up)
      for (int i = 0; i < 2; i++) {
        // Move in the current direction for 'steps' times
        for (int j = 0; j < steps; j++) {
          // Update the position based on the current direction
          rPointer += directions[dirIndex][0];
          cPointer += directions[dirIndex][1];

          // Check if the new position is within the grid boundaries
          if (rPointer >= 0 && rPointer < rows && cPointer >= 0 && cPointer < cols) {
            // If within boundaries, add the position to the result array
            res[counter++] = new int[] {rPointer, cPointer};
          }
        }
        // Change to the next direction (right -> down -> left -> up)
        dirIndex = (dirIndex + 1) % 4;
      }
      // Increase the step size after completing a full cycle of two turns
      steps++;
    }

    // Return the result array containing the coordinates in the order they were visited
    return res;
  }
}
