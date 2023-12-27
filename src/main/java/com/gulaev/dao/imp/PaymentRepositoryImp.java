package com.gulaev.dao.imp;

import com.gulaev.dao.DbUtils;
import com.gulaev.dao.PaymentRepository;
import com.gulaev.model.Payment;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class PaymentRepositoryImp implements PaymentRepository {


  @Override
  public void create(Payment payment) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(PaymentRepository.class).create(payment);
    }
  }

  @Override
  public Optional<Payment> getById(Integer paymentId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(PaymentRepository.class).getById(paymentId);
    }
  }

  @Override
  public void update(Integer paymentId, Payment payment) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(PaymentRepository.class).update(paymentId, payment);
    }
  }

  @Override
  public void deleteById(Integer paymentId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(PaymentRepository.class).deleteById(paymentId);
    }
  }

  @Override
  public List<Payment> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(PaymentRepository.class).getAll();
    }
  }
}
