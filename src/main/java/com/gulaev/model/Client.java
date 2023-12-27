package com.gulaev.model;

import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public class Client {

  private Integer clientId;
  private String firstName;
  private String lastName;
  private Passport passport;
  private List<BankCard> bankCards;
  private List<Contract> contracts;

  @Override
  public String toString() {
    return "Client{" +
        "clientId=" + clientId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", passport=" + passport + '\'' +
        ", bankCards=" + bankCards +'\'' +
        '}';
  }
}
