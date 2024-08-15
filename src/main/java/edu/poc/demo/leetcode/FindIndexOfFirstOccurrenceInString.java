package edu.poc.demo.leetcode;

public class FindIndexOfFirstOccurrenceInString {

    private int strStr(String haystack, String needle) {

        outer: for(int i = 0; i < haystack.length() ; i++ ){
            int slidingPointer = i;
            for(int k = 0; k < needle.length() ; k++ ){

                if( slidingPointer >= haystack.length() || haystack.charAt(slidingPointer++) != needle.charAt(k) )
                    continue outer;
            }
            return i;
        }
        return -1;

    }
}
