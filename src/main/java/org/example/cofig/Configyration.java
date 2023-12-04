package org.example.cofig;

import org.example.enitty.Planet;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Configyration {
  private static final Configyration INSTANCE = new Configyration();
  private SessionFactory sessionFactory;

  public Configyration(){
    this.sessionFactory = new Configuration()
            .addAnnotatedClass(Planet.class)
            .buildSessionFactory();

    /*flywayMigration(PropertyReader.getConnectionUrlForPostgres(),
            PropertyReader.getUserForPostgres(),
            PropertyReader.getPasswordForPostgres());*/
    flyli();

  }

  static final String JDBC_DRIVER = "org.h2.Driver";
  static final String DB_URL = "jdbc:h2:./test";

  static final String USER = "sa";
  static final String PASS = "";
  public static Configyration getInstance() {
    return INSTANCE;
  }
  public Connection getConections() {
    try {
      return DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }

  public void closeSessionFactory() {
    this.sessionFactory.close();
  }


  /*private void flywayMigration(String connectionUrl, String username, String password) {
    Flyway flyway = Flyway.configure().dataSource(connectionUrl, username, password).load();
    flyway.migrate();
  }*/
  public void flyli() {


    Flyway flyway = Flyway.configure().dataSource(DB_URL,
            USER, PASS).load();
    flyway.migrate();
  }

}
