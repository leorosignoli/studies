package edu.poc.demo.leetcode;


import edu.poc.demo.utils.ExecutionMeasure;

public class SmallestGreaterInteger {

    public static void main(String[] args) {
        ExecutionMeasure.measureExecutionTime( () -> new Solution().solution(413021));
    }

    static class Solution {
        int solution ( int n){
        char[] digits = Integer.toString(n).toCharArray();
        int length = digits.length, i = length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) i--;
        if (i == -1) return -1; //No permutation greater than n possible
        int j = length - 1;
        while (j >= 0 && digits[j] <= digits[i]) j--;
        swap(digits, i, j);
            reverse(digits, i + 1, length - 1);
            return Integer.parseInt(new String(digits));
    }

        private void swap ( char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
        private void reverse (char[] arr, int start, int end){
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        }
    }


}
