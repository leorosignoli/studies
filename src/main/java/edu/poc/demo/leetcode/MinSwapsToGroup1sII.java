package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSwapsToGroup1sII {


    public static void main(String[] args) {
        ExecutionMeasure.measureExecutionTime(() -> minSwaps(new int[]{0,1,1,1,0,0,1,1,0}));
        ExecutionMeasure.measureExecutionTime(() -> minSwaps(new int[]{0,1,0,1,1,0,0}));
        ExecutionMeasure.measureExecutionTime(() -> minSwaps(new int[]{1,1,0,0,1})); //1
    }
    public static int minSwaps(int[] nums) {

        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());

        int min = Integer.MAX_VALUE;
        int ones = (int) list.stream().filter(i -> i == 1).count();



        for (int i = 0; i < list.size(); i++) {
            int zeros = 0;
            int r = i + ones;
            int l = i;
            while (l < r) {
                if (list.get(l % list.size()) == 0) {
                    zeros++;
                }
                l++;
            }
            min = Math.min(zeros, min);
        }
        return min;

    }
}
