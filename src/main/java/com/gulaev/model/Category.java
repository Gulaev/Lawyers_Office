package com.gulaev.model;

public enum Category {

  CIVIL(0),
  CRIMINAL(1),
  FAMILY(2),
  BUSINESS(3);

  private int i;

  Category(int i) {
    this.i = i;
  }

  public int getI() {
    return i;
  }
}
