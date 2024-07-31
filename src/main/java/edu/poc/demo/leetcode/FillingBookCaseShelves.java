package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * 1105. Filling Bookcase Shelves
 *
 * <p>You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness
 * and height of the ith book. You are also given an integer shelfWidth.
 *
 * <p>We want to place these books in order onto bookcase shelves that have a total width
 * shelfWidth.
 *
 * <p>We choose some of the books to place on this shelf such that the sum of their thickness is
 * less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that
 * the total height of the bookcase has increased by the maximum height of the books we just put
 * down. We repeat this process until there are no more books to place.
 *
 * <p>Note that at each step of the above process, the order of the books we place is the same order
 * as the given sequence of books.
 *
 * <p>For example, if we have an ordered list of 5 books, we might place the first and second book
 * onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the
 * last shelf. Return the minimum possible height that the total bookshelf can be after placing
 * shelves in this manner.
 */
public class FillingBookCaseShelves {

  public static void main(String[] args) {
    int[][] books = {{1, 4}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
    int shelfWidth = 4;
    ExecutionMeasure.measureExecutionTime(() -> minHeightShelves(books, shelfWidth));
  }

  private static int thickness = 0; // Index for book thickness
  private static int height = 1; // Index for book height

  private static int minHeightShelves(int[][] books, int shelfWidth) {
    int n = books.length;
    int[] minimumHeight =
        new int[n + 1]; // Array to store the minimum height needed to place the first i books
    minimumHeight[0] = 0; // no books, no height

    for (int i = 1; i <= n; i++) { // Loop through each book
      int width = 0, maxHeight = 0; // Initialize current shelf width and max height
      minimumHeight[i] =
          Integer.MAX_VALUE; // Initialize the minimum height for the first i books to a large value

      for (int j = i;
          j > 0;
          j--) { // Start from the current book i and go backwards to the first book j
        int[] previousBook = books[j - 1];
        width +=
            previousBook[
                thickness]; // Add the thickness (width) of the current book to the current shelf
        // width
        if (width > shelfWidth)
          break; // If the accumulated width exceeds shelfWidth, break out of the inner loop and go
        // to the next number.
        maxHeight =
            Math.max(
                maxHeight,
                previousBook[height]); // Determine the tallest book in the current shelf segment
        minimumHeight[i] =
            Math.min(
                minimumHeight[i],
                minimumHeight[j - 1]
                    + maxHeight); // Update the minimum height needed to place the first i books
      }
    }
    return minimumHeight[n];
  }
}
