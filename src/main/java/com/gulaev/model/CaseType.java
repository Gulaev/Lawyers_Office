package com.gulaev.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement(name = "caseType")
@XmlType(propOrder = {"caseTypeId", "caseTypeName", "legalRequirements",
    "feesStructure", "averageCaseCost"})
public class CaseType {

  private Integer caseTypeId;
  private String caseTypeName;
  private Category category;
  private String legalRequirements;
  private String feesStructure;
  private Integer averageCaseCost;


  public void setCaseTypeId(Integer caseTypeId) {
    this.caseTypeId = caseTypeId;
  }

  @XmlElement
  public void setCaseTypeName(String caseTypeName) {
    this.caseTypeName = caseTypeName;
  }
  @XmlTransient
  public void setCategory(Category category) {
    this.category = category;
  }

  @XmlElement
  public void setLegalRequirements(String legalRequirements) {
    this.legalRequirements = legalRequirements;
  }

  @XmlElement
  public void setFeesStructure(String feesStructure) {
    this.feesStructure = feesStructure;
  }

  @XmlElement
  public void setAverageCaseCost(Integer averageCaseCost) {
    this.averageCaseCost = averageCaseCost;
  }
}
