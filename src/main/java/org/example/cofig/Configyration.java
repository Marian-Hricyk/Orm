package org.example.cofig;

import org.example.enitty.Planet;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Configyration {
  private static final Configyration INSTANCE = new Configyration();
  private SessionFactory sessionFactory;

  public Configyration(){
    this.sessionFactory = new Configuration()
            .addAnnotatedClass(Planet.class)
            .buildSessionFactory();
    flywayMigration(PropertyReader.getConnectionUrlForPostgres(),
            PropertyReader.getUserForPostgres(),
            PropertyReader.getPasswordForPostgres());

  }
  public static Configyration getInstance() {
    return INSTANCE;
  }

  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }

  public void closeSessionFactory() {
    this.sessionFactory.close();
  }


  private void flywayMigration(String connectionUrl, String username, String password) {
    Flyway flyway = Flyway.configure().dataSource(connectionUrl, username, password).load();
    flyway.migrate();
  }

}
