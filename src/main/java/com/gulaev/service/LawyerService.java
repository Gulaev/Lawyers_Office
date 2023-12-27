package com.gulaev.service;

import com.gulaev.dao.imp.LawyerRepositoryImp;
import com.gulaev.model.Lawyer;

public class LawyerService {

  private LawyerRepositoryImp lawyerRepositoryImp;

  public LawyerService() {
    this.lawyerRepositoryImp = new LawyerRepositoryImp();
  }

  public Lawyer getById(Integer id) {
    return lawyerRepositoryImp.getById(id).get();
  }
}
