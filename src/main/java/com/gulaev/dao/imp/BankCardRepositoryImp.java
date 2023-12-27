package com.gulaev.dao.imp;

import com.gulaev.dao.BankCardRepository;
import com.gulaev.dao.DbUtils;
import com.gulaev.model.BankCard;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class BankCardRepositoryImp implements BankCardRepository {


  @Override
  public void create(BankCard bankCard) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(BankCardRepository.class).create(bankCard);
    }

  }

  @Override
  public Optional<BankCard> getById(Integer bankCardId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(BankCardRepository.class).getById(bankCardId);
    }
  }

  @Override
  public void update(Integer id, BankCard bankCard) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(BankCardRepository.class).update(id, bankCard);
    }
  }


  @Override
  public void deleteById(Integer bankCardId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(BankCardRepository.class).deleteById(bankCardId);
    }
  }

  @Override
  public List<BankCard> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(BankCardRepository.class).getAll();
    }
  }

  @Override
  public boolean existByBankCardId(Integer bankCardId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(BankCardRepository.class).existByBankCardId(bankCardId);
    }
  }
}
