package com.gulaev.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "passport")
@XmlType(propOrder = {"passportId", "tin", "dateOfIssue", "issuedBy"})
public class Passport {

  private Integer passportId;
  private String tin;
  private Date dateOfIssue;
  private String issuedBy;

  @XmlElement(name = "passportId")
  public void setPassportId(Integer passportId) {
    this.passportId = passportId;
  }

  @XmlElement(name = "tin")
  public void setTin(String tin) {
    this.tin = tin;
  }

  @XmlElement(name = "dateOfIssue")
  public void setDateOfIssue(Date dateOfIssue) {
    this.dateOfIssue = dateOfIssue;
  }

  @XmlElement(name = "issuedBy")
  public void setIssuedBy(String issuedBy) {
    this.issuedBy = issuedBy;
  }
}
