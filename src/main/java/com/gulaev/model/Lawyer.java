package com.gulaev.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "lawyer")
@XmlType(propOrder = {"lawyerId", "firstName", "lastName","officeRoomNumber",
    "passport"})
public class Lawyer {

  private Integer lawyerId;
  private String firstName;
  private String lastName;
  private Integer officeRoomNumber;
  private Passport passport;
  private List<Contract> contracts;


  @Override
  public String toString() {
    return "Lawyer{" +
        "lawyerId=" + lawyerId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", officeRoomNumber=" + officeRoomNumber +
        ", passport=" + passport +
        '}';
  }

  @XmlElement(name = "lawyerId")
  public void setLawyerId(Integer lawyerId) {
    this.lawyerId = lawyerId;
  }

  @XmlElement(name = "firstName")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @XmlElement(name = "lastName")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @XmlElement(name = "officeRoomNumber")
  public void setOfficeRoomNumber(Integer officeRoomNumber) {
    this.officeRoomNumber = officeRoomNumber;
  }

  @XmlElement(name = "passport")
  public void setPassport(Passport passport) {
    this.passport = passport;
  }

  @XmlTransient
  public void setContracts(List<Contract> contracts) {
    this.contracts = contracts;
  }
}
