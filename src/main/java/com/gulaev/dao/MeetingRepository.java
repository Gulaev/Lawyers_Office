package com.gulaev.dao;

import com.gulaev.model.Meeting;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface MeetingRepository {

  void create(Meeting meeting);

  Optional<Meeting> getById(Integer meetingId);

  void update(@Param("meetingId") Integer meetingId,
      @Param("meeting") Meeting meeting);

  void deleteById(Integer meetingId);

  List<Meeting> getAll();

}
