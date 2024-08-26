package edu.poc.demo.leetcode;

/** */
public class CarPooling {

  public static boolean carPooling(int[][] trips, int capacity) {
    // Array to keep track of the number of passengers at each kilometer
    int[] passengerChanges = new int[1001];
    int lastKilometer = 0;

    // Update the array based on the trips
    for (int[] trip : trips) {
      int numPassengers = trip[0];
      int pickUp = trip[1];
      int dropOff = trip[2];

      passengerChanges[pickUp] += numPassengers; // Add passengers at pick-up point
      passengerChanges[dropOff] -= numPassengers; // Remove passengers at drop-off point
      lastKilometer = Math.max(lastKilometer, dropOff);
    }

    // Calculate the number of passengers at each kilometer and check capacity
    int currentPassengers = 0;
    for (int i = 0; i <= lastKilometer; i++) {
      currentPassengers += passengerChanges[i];
      if (currentPassengers > capacity) {
        return false; // Capacity exceeded
      }
    }

    return true; // All trips can be handled within the capacity
  }

  public static void main(String[] args) {

    int[][] trips1 = {{2, 1, 5}, {3, 3, 7}};
    int capacity1 = 4;
    System.out.println(carPooling(trips1, capacity1)); // Output: false

    int[][] trips2 = {{2, 1, 5}, {3, 3, 7}, {3, 9, 10}};
    int capacity2 = 5;
    System.out.println(carPooling(trips2, capacity2)); // Output: true
  }
}
