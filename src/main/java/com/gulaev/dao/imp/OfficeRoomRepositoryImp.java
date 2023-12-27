package com.gulaev.dao.imp;

import com.gulaev.dao.DbUtils;
import com.gulaev.dao.OfficeRoomRepository;
import com.gulaev.model.OfficeRoom;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class OfficeRoomRepositoryImp implements OfficeRoomRepository {


  @Override
  public void create(OfficeRoom officeRoom) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(OfficeRoomRepository.class).create(officeRoom);
    }
  }

  @Override
  public Optional<OfficeRoom> getById(Integer officeRoomId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(OfficeRoomRepository.class).getById(officeRoomId);
    }
  }

  @Override
  public void update(Integer officeRoomId, OfficeRoom officeRoom) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(OfficeRoomRepository.class).update(officeRoomId, officeRoom);
    }
  }

  @Override
  public void deleteById(Integer officeRoomId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(OfficeRoomRepository.class).deleteById(officeRoomId);
    }
  }

  @Override
  public List<OfficeRoom> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(OfficeRoomRepository.class).getAll();
    }
  }
}
