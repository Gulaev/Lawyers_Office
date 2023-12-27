package com.gulaev.dao;

import com.gulaev.model.Contract;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface ContractRepository {

  void create(Contract contract);

  Optional<Contract> getById(Integer contractId);

  void update(@Param("contractId") Integer id,
      @Param("contract") Contract contract);

  void deleteById(Integer contractId);

  List<Contract> getAll();

  List<Contract> getByClientId(Integer clientId);

  List<Contract> getByLawyerId(Integer lawyerId);

  boolean existByContractId(Integer contractId);

}
