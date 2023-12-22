package com.gulaev.dao;

import java.util.List;

public interface Repository<T, V> {

  void create(V v);

  V getById(T t);

  void update(V v, T t);

  void deleteById(T t);

  List<V> getAll();

}
