package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

import java.util.Arrays;

/**
 * 135. Candy
 * Attempted
 * Hard
 *
 * Topics
 * Companies
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 *
 *
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 *
 *
 * Constraints:
 *
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 */
public class Candy {

    public static void main(String[] args) {
        ExecutionMeasure.measureExecutionTime(() -> candy(new int[]{1,2,87,87,87,2,1}));
    }

    static int candy(int[] ratings) {

        // traverse from left to right

        int[] candiesPerKid = new int[ratings.length];
        Arrays.fill(candiesPerKid, 1);

        for (int i = 0 ; i < ratings.length ; i++){
            if (ratings[i] > ratings[i+1] && candiesPerKid[i] <= candiesPerKid[i+1] ){
                candiesPerKid[i] = candiesPerKid[i+1]+1;
            }
        }

        // reverse traversaal
        for(int j = ratings.length-1 ; j > 0 ; j--){
            if(ratings[j] > ratings[j-1] && candiesPerKid[j] <= candiesPerKid[j-1]){
                candiesPerKid[j] = candiesPerKid[j-1]+1;
            }
        }

        int totalCandies = 0;
        for(int candies: candiesPerKid)
            totalCandies += candies;

        return totalCandies;

    }
}
