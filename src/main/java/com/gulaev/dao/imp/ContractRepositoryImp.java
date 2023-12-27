package com.gulaev.dao.imp;

import com.gulaev.dao.ContractRepository;
import com.gulaev.dao.DbUtils;
import com.gulaev.model.Contract;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class ContractRepositoryImp implements ContractRepository {

  @Override
  public void create(Contract contract) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(ContractRepository.class).create(contract);
    }
  }

  @Override
  public Optional<Contract> getById(Integer id) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(ContractRepository.class).getById(id);
    }
  }

  @Override
  public void update(Integer id, Contract contract) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(ContractRepository.class).update(id, contract);
    }
  }


  @Override
  public void deleteById(Integer contractId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(ContractRepository.class).deleteById(contractId);
    }

  }

  @Override
  public List<Contract> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(ContractRepository.class).getAll();
    }
  }

  @Override
  public List<Contract> getByClientId(Integer clientId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(ContractRepository.class).getByClientId(clientId);
    }
  }

  @Override
  public List<Contract> getByLawyerId(Integer lawyerId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(ContractRepository.class).getByLawyerId(lawyerId);
    }
  }

  @Override
  public boolean existByContractId(Integer contractId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(ContractRepository.class).existByContractId(contractId);
    }
  }
}
