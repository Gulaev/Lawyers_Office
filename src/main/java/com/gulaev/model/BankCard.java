package com.gulaev.model;

import java.util.Date;
import lombok.Data;

@Data
public class BankCard {

  private Integer bankCardId;
  private String cardNumber;
  private Date dateEnd;
  private Integer cvv;
  private String nameOnCard;
  private Integer clientId;
}
