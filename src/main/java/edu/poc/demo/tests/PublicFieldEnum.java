package edu.poc.demo.tests;

public enum PublicFieldEnum {
  ONE(4);

  public final Integer val;

  PublicFieldEnum(Integer val) {
    this.val = val;
  }
}
