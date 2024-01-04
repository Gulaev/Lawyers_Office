package com.gulaev.service;

import com.gulaev.dao.ContractRepository;
import com.gulaev.dao.imp.ContractRepositoryImp;
import com.gulaev.model.Contract;
import java.util.List;

public class ContractService implements Service<Contract> {

  private ContractRepository contractRepository;

  public ContractService() {
    this.contractRepository = new ContractRepositoryImp();
  }

  public Contract getById(Integer id) {
    return contractRepository.getById(id).get();
  }

  public List<Contract> getAll() {
    return contractRepository.getAll();
  }

  public void create(Contract contract) {
    contractRepository.create(contract);
  }

  public void update(Contract contract, Integer id) {
    contractRepository.update(id, contract);
  }
}
