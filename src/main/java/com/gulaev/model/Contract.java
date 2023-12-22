package com.gulaev.model;

import java.util.Date;
import lombok.Data;

@Data
public class Contract {

  private Integer contractId;
  private Date startDate;
  private Payment payment;
  private CaseType caseType;
  private Client client;
  private Lawyer lawyer;

}
