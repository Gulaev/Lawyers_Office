package com.gulaev.dao;

import com.gulaev.model.OfficeRoom;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

public interface OfficeRoomRepository {

  void create(OfficeRoom officeRoom);

  Optional<OfficeRoom> getById(Integer officeRoomId);

  void update(@Param("officeRoomId") Integer officeRoomId,
      @Param("officeRoom") OfficeRoom officeRoom);

  void deleteById(Integer officeRoomId);

  List<OfficeRoom> getAll();

}
