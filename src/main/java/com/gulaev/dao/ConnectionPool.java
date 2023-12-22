package com.gulaev.dao;

import java.sql.Connection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

  private static ConnectionPool instance;
  private BlockingQueue<Connection> pool;

  private ConnectionPool(int capacity) {
    pool = new LinkedBlockingQueue<>(capacity);
      for (int i = 0; capacity > i; i++) {
        pool.add(DbUtils.getConnection());
      }
  }

  public static synchronized ConnectionPool getInstance(int capacity) {
      if (instance == null ) {
        instance = new ConnectionPool(capacity);
      }
      return instance;
  }

  public Connection getConnection() {
    try {
      return pool.take();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public void releaseConnection(Connection connection) {
    pool.add(connection);
  }

}
