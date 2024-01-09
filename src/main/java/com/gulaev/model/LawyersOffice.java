package com.gulaev.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "lawyersOffice")
@XmlType(propOrder = {"officeId", "streetAddress"})
public class LawyersOffice {

  private Integer officeId;
  private String streetAddress;

  @XmlElement(name = "officeId")
  public Integer getOfficeId() {
    return officeId;
  }

  public void setOfficeId(Integer officeId) {
    this.officeId = officeId;
  }

  @XmlElement(name = "streetAddress")
  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }
}

