package com.gulaev.service;

import com.gulaev.dao.imp.LawyerRepository;
import com.gulaev.model.Lawyer;

public class LawyerService {

  private LawyerRepository lawyerRepository;

  public LawyerService() {
    this.lawyerRepository = new LawyerRepository();
  }

  public Lawyer getById(Integer id) {
    return lawyerRepository.getById(id);
  }
}
