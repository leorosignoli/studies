package edu.poc.demo.leetcode;

import edu.poc.demo.utils.ExecutionMeasure;

/**
 * 2678. Number of Senior Citizens
 *
 * <p>You are given a 0-indexed array of strings details. Each element of details provides
 * information about a given passenger compressed into a string of length 15. The system is such
 * that:
 *
 * <p>The first ten characters consist of the phone number of passengers. The next character denotes
 * the gender of the person. The following two characters are used to indicate the age of the
 * person. The last two characters determine the seat allotted to that person. Return the number of
 * passengers who are strictly more than 60 years old.
 */
public class NumberOfSeniorCitizens {

  public static void main(String[] args) {
    ExecutionMeasure.measureExecutionTime(
        () ->
            countSeniors(
                new String[] {"1234567890M23A01", "1234567890F23A01", "1234567890M60A01"}));
  }

  private static int countSeniors(String[] details) {

    int seniorCitizensCount = 0;

    for (String citizenDetail : details) {
      if (getCitizenAge(citizenDetail) > 60) seniorCitizensCount++;
    }
    return seniorCitizensCount;
  }

  private static int getCitizenAge(String citizenDetail) {
    return Integer.parseInt(citizenDetail.substring(11, 13));
  }
}
