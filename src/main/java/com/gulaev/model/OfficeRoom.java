package com.gulaev.model;

import lombok.Data;

@Data
public class OfficeRoom {

  private Integer officeRoomId;
  private Integer officeRoomNumber;
  private Integer floorNumber;
  private LawyersOffice lawyersOffice;
}
