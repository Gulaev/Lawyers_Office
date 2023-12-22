package com.gulaev.model;

import java.util.Date;
import lombok.Data;

@Data
public class Passport {

  private Integer passortId;
  private String tin;
  private Date dateOfIssue;
  private String issuedBy;

}
