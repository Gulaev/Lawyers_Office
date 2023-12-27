package com.gulaev.dao.imp;

import com.gulaev.dao.DbUtils;
import com.gulaev.dao.PassportRepository;
import com.gulaev.model.Passport;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class PassportRepositoryImp implements PassportRepository {


  @Override
  public void create(Passport passport) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(PassportRepository.class).create(passport);
    }
  }

  @Override
  public Optional<Passport> getById(Integer passportId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(PassportRepository.class).getById(passportId);
    }
  }

  @Override
  public void update(Integer passportId, Passport passport) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(PassportRepository.class).update(passportId, passport);
    }
  }

  @Override
  public void deleteById(Integer passportId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(PassportRepository.class).deleteById(passportId);
    }
  }

  @Override
  public List<Passport> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(PassportRepository.class).getAll();
    }
  }

  @Override
  public boolean checkPassportExists(int passportId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(PassportRepository.class).checkPassportExists(passportId);
    }
  }


}
