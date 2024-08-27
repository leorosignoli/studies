package edu.poc.demo.tests;

public class ChangeEnumVal {

  public static void main(String[] args) {
    System.out.println(PublicFieldEnum.ONE.val);
    var test = PublicFieldEnum.ONE.val;
    test = 5;
    System.out.println(PublicFieldEnum.ONE.val);
  }
}
