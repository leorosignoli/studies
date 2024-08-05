package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        ExecutionMeasure.measureExecutionTime(() -> removeElement(new int[]{3, 2, 2, 3}, 3));
        ExecutionMeasure.measureExecutionTime(() -> removeElementImproved(new int[]{3, 4, 2,3,3, 1, 3}, 3));

    }

    public static int removeElement(int[] nums, int val) {

        int valCounter = 0;
        // remove all ocurrences of val from nums, replace the ocurrences with int max value
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == val){

                nums[i] = Integer.MAX_VALUE;
            } else {
                valCounter++;
            }

        }

        //sort by value
        Arrays.sort(nums);
        // return nums size - ocurrence of val
        return valCounter;


    }

    public static int removeElementImproved(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
