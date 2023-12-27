package com.gulaev.dao.imp;

import com.gulaev.dao.DbUtils;
import com.gulaev.dao.LawyersRepository;
import com.gulaev.model.Contract;
import com.gulaev.model.Lawyer;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class LawyerRepositoryImp implements LawyersRepository {

  @Override
  public void create(Lawyer lawyer) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      PassportRepositoryImp passportRepositoryImp = new PassportRepositoryImp();
      if (lawyer.getPassport() != null &&
          !passportRepositoryImp.checkPassportExists(lawyer.getPassport().getPassportId())) {
        passportRepositoryImp.create(lawyer.getPassport());
      }
      sqlSession.getMapper(LawyersRepository.class).create(lawyer);
    }
  }

  @Override
  public Optional<Lawyer> getById(Integer lawyerId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(LawyersRepository.class).getById(lawyerId);
    }

  }

  @Override
  public void update(Integer lawyerId, Lawyer lawyer) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      PassportRepositoryImp passportRepositoryImp = new PassportRepositoryImp();
      if (lawyer.getPassport() != null &&
          !passportRepositoryImp.checkPassportExists(lawyer.getPassport().getPassportId())) {
        passportRepositoryImp.create(lawyer.getPassport());
      }
        if (lawyer.getContracts() != null) {
          for (Contract contract : lawyer.getContracts()) {
            ContractRepositoryImp contractRepositoryImp = new ContractRepositoryImp();
            if (contractRepositoryImp.existByContractId(contract.getContractId())) {
              contractRepositoryImp.update(contract.getContractId(), contract);
            } else {
              contractRepositoryImp.create(contract);
            }
          }
        }
      sqlSession.getMapper(LawyersRepository.class).update(lawyerId, lawyer);
    }
  }

  @Override
  public void deleteById(Integer lawyerId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(LawyersRepository.class).deleteById(lawyerId);
    }
  }

  @Override
  public List<Lawyer> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(LawyersRepository.class).getAll();
    }
  }
}
