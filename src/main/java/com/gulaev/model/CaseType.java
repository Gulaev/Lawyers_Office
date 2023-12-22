package com.gulaev.model;

import lombok.Data;

@Data
public class CaseType {

  private Integer caseTypeId;
  private String caseTypeName;
  private Category category;
  private String LegalRequirements;
  private String FeesStructure;
  private Integer averageCaseCost;
}
