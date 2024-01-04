package com.gulaev.service;

import java.util.List;

public interface Service<T> {

  T getById(Integer id);

  List<T> getAll();

  void create(T t);

  void update(T t, Integer id);

}
