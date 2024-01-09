package com.gulaev.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "contract")
@XmlType(propOrder = {"contractId", "startDate", "client",
    "lawyer"})
public class Contract {

  private Integer contractId;
  private Date startDate;
  private Payment payment;
  private CaseType caseType;
  private Client client;
  private Lawyer lawyer;

  @XmlElement(name = "contractId")
  public void setContractId(Integer contractId) {
    this.contractId = contractId;
  }

  @XmlElement(name = "startDate")
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  @XmlElement(name = "client")
  public void setClient(Client client) {
    this.client = client;
  }

  @XmlElement(name = "lawyer")
  public void setLawyer(Lawyer lawyer) {
    this.lawyer = lawyer;
  }
}
