package com.gulaev.model;

import java.util.List;
import lombok.Data;

@Data
public class Lawyer {

  private Integer lawyerId;
  private String firstName;
  private String lastName;
  private Integer officeRoomNumber;
  private Passport passport;
  private List<Contract> contracts;


  @Override
  public String toString() {
    return "Lawyer{" +
        "lawyerId=" + lawyerId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", officeRoomNumber=" + officeRoomNumber +
        ", passport=" + passport +
        '}';
  }
}
