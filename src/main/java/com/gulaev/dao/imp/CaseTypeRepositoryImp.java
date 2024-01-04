package com.gulaev.dao.imp;

import com.gulaev.dao.CaseTypeRepository;
import com.gulaev.dao.DbUtils;
import com.gulaev.model.CaseType;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class CaseTypeRepositoryImp implements CaseTypeRepository {


  @Override
  public void create(CaseType caseType) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(CaseTypeRepository.class).create(caseType);
    }

  }

  @Override
  public Optional<CaseType> getById(Integer caseTypeId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(CaseTypeRepository.class).getById(caseTypeId);
    }
  }

  @Override
  public void update(Integer id, CaseType caseType) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(CaseTypeRepository.class).update(id, caseType);
    }
  }


  @Override
  public void deleteById(Integer caseTypeId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(CaseTypeRepository.class).deleteById(caseTypeId);
    }
  }

  @Override
  public List<CaseType> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(CaseTypeRepository.class).getAll();
    }
  }
}
