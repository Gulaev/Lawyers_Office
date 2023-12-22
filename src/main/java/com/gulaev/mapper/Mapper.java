package com.gulaev.mapper;

import java.sql.ResultSet;

public interface Mapper<T> {

  T mapRow(ResultSet rs);

}
