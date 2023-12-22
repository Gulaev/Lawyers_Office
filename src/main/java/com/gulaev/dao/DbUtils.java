package com.gulaev.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DbUtils {

  private static final Logger LOGGER = LogManager.getLogger(DbUtils.class);

  public static Connection getConnection() {
    Connection connection = null;
    Properties properties = new Properties();
    try {
      properties.load(DbUtils.class.getClassLoader()
          .getResourceAsStream("config.properties"));

      connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
          properties.getProperty("dbUsername"), properties.getProperty("dbPassword"));

    } catch (SQLException e) {
      throw new RuntimeException(e);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return connection;
  }
}
