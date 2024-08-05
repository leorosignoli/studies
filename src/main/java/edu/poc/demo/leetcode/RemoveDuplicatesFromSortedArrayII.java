package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        ExecutionMeasure.measureExecutionTime(() -> removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
    private static int removeDuplicates(int[] nums) {

        int pivot = 1;
        int evalInt = nums[0];
        int countInt = 1;
        for (int i = 0 ; i < nums.length ; i++ ){
            if (nums[i] == evalInt && countInt < 2){
                countInt++;
                pivot++;
            }
            else if (nums[i] != evalInt){
                nums[pivot++] = nums[i];
                evalInt = nums[i];
                countInt = 1;
            }
        }
        return pivot+1;
    }
}


