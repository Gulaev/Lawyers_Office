package com.gulaev.model;

import lombok.Data;

@Data
public class Meeting {

  private Integer meetingId;
  private Lawyer lawyer;
  private Client client;
  private OfficeRoom officeRoom;
}
