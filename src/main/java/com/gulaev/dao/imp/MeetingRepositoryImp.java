package com.gulaev.dao.imp;

import com.gulaev.dao.DbUtils;
import com.gulaev.dao.MeetingRepository;
import java.util.List;
import com.gulaev.model.Meeting;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;

public class MeetingRepositoryImp implements MeetingRepository {


  @Override
  public void create(Meeting meeting) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(MeetingRepository.class).create(meeting);
    }
  }

  @Override
  public Optional<Meeting> getById(Integer meetingId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
     return sqlSession.getMapper(MeetingRepository.class).getById(meetingId);
    }
  }

  @Override
  public void update(Integer id, Meeting meeting) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(MeetingRepository.class).update(id, meeting);
    }
  }

  @Override
  public void deleteById(Integer meetingId) {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      sqlSession.getMapper(MeetingRepository.class).deleteById(meetingId);
    }
  }

  @Override
  public List<Meeting> getAll() {
    try (SqlSession sqlSession = DbUtils.getSessionFactory().openSession(true)) {
      return sqlSession.getMapper(MeetingRepository.class).getAll();
    }
  }
}
