package com.gulaev.dao.imp;

import com.gulaev.dao.DbUtils;
import com.gulaev.dao.LawyersOfficeRepository;
import com.gulaev.model.LawyersOffice;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class LawyersOfficeRepositoryImp implements LawyersOfficeRepository {


  @Override
  public void create(LawyersOffice lawyersOffice) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(LawyersOfficeRepository.class).create(lawyersOffice);
    }
  }

  @Override
  public Optional<LawyersOffice> getById(Integer lawyerOfficeId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(LawyersOfficeRepository.class).getById(lawyerOfficeId);
    }
  }

  @Override
  public void update(Integer id, LawyersOffice lawyersOffice) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {

      sqlSession.getMapper(LawyersOfficeRepository.class).update(id, lawyersOffice);
    }
  }

  @Override
  public void deleteById(Integer lawyerOfficeId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(LawyersOfficeRepository.class).deleteById(lawyerOfficeId);
    }
  }

  @Override
  public List<LawyersOffice> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
     return sqlSession.getMapper(LawyersOfficeRepository.class).getAll();
    }
  }
}
