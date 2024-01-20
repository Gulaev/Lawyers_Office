package com.gulaev.factory;

public class DBFactory {

  public static Factory getDBFactory(String pattern) {
    switch(pattern) {
      case "XML":
        return new XMLDBFactory();
      case "JSON":
        return new JSONDBFactory();
      default:
        throw new RuntimeException("DB pattern name incorrect");
    }
  }

}
