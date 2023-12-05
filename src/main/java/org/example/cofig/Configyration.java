package org.example.cofig;

import org.example.enitty.Client;
import org.example.enitty.Planet;
import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Configyration {
  private static final Configyration INSTANCE = new Configyration();
  private SessionFactory sessionFactory;

  public Configyration() {
    this.sessionFactory = new Configuration()
            .addAnnotatedClass(Planet.class)
            .addAnnotatedClass(Client.class)
            .buildSessionFactory();


    flyli(PropertyReader.getConnectionUrlForH2());

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

  public void flyli(String DB_URL) {
    String USER = "";
    String PASS = "";

    Flyway flyway = Flyway.configure().dataSource(DB_URL,
            USER, PASS).load();
    flyway.migrate();
  }

}
