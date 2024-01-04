package com.gulaev.service;

import com.gulaev.dao.MeetingRepository;
import com.gulaev.dao.imp.MeetingRepositoryImp;
import com.gulaev.model.Meeting;
import java.util.List;

public class MeetingService implements Service<Meeting> {

  private MeetingRepository meetingRepository;

  public MeetingService() {
    this.meetingRepository = new MeetingRepositoryImp();
  }

  public Meeting getById(Integer id) {
    return meetingRepository.getById(id).get();
  }

  public List<Meeting> getAll() {
    return meetingRepository.getAll();
  }

  public void create(Meeting meeting) {
    meetingRepository.create(meeting);
  }

  public void update(Meeting meeting, Integer id) {
    meetingRepository.update(id, meeting);
  }
}
