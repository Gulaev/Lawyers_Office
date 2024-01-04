package com.gulaev.service;

import com.gulaev.dao.CaseTypeRepository;
import com.gulaev.dao.imp.CaseTypeRepositoryImp;
import com.gulaev.model.CaseType;
import java.util.List;

public class CaseTypeService implements Service<CaseType> {

  private CaseTypeRepository caseTypeRepository;

  public CaseTypeService() {
    this.caseTypeRepository = new CaseTypeRepositoryImp();
  }

  public CaseType getById(Integer id) {
    return caseTypeRepository.getById(id).get();
  }

  public List<CaseType> getAll() {
    return caseTypeRepository.getAll();
  }

  public void create(CaseType caseType) {
    caseTypeRepository.create(caseType);
  }

  public void update(CaseType caseType, Integer id) {
    caseTypeRepository.update(id, caseType);
  }
}
