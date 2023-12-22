package com.gulaev.model;

import java.util.List;
import lombok.Data;

@Data
public class Client {

  private Integer clientId;
  private String firstName;
  private String lastName;
  private Passport passport;
  private List<BankCard> bankCards;
  private List<Contract> contracts;


}
