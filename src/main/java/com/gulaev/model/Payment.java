package com.gulaev.model;

import java.util.Date;
import lombok.Data;

@Data
public class Payment {

  private Integer paymentId;
  private Date dateOfPayment;
  private Client client;
  private Lawyer lawyer;
  private Integer lawyerAmount;


}
