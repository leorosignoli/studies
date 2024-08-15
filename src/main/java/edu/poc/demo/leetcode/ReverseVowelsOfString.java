package edu.poc.demo.leetcode;

import java.util.List;

/**
 * 345. Reverse Vowels of a String
 * Solved
 * Easy
 *
 * Topics
 * Companies
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: "leotcede"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
public class ReverseVowelsOfString {

    private static final List<Character> vowls = List.of('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U');
    private String reverseVowels(String s) {

        char[] res = new char[s.length()];


        int left = 0;
        int right = s.length()-1;

        for (int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);

            while( isVowel(c) && right > i  ){
                if(!isVowel(s.charAt(right)) ){
                    right--;
                } else {
                    char temp = c;
                    c = s.charAt(right);
                    res[right--] = temp;
                    break;
                }
            }

            if (res[i] == '\u0000')
                res[i] = c;
            left++;

        }
        return String.valueOf(res);

    }
    private static boolean isVowel(Character c){
        return vowls.contains(c);
    }

}
