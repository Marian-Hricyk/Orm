package org.example.dao;

import org.example.cofig.Configyration;
import org.example.enitty.Client;
import org.example.enitty.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Planetdao {
  private SessionFactory sessionFactory = Configyration.getInstance().getSessionFactory();

  public void save(Planet planet){
    try(Session session=sessionFactory.openSession()){
      Transaction transaction=session.beginTransaction();
      session.save(planet);
      transaction.commit();
    }
  }



  public Planet findById(Long id) {
    try (Session session = sessionFactory.openSession()) {
      return session.get(Planet.class, id);
    }
  }


  public void update(Planet planet) {
    try (Session session = sessionFactory.openSession()) {
      Transaction tx = session.beginTransaction();
      session.update(planet);
      tx.commit();
    }
  }

  public void delete(Planet planet) {
    try (Session session = sessionFactory.openSession()) {
      Transaction tx = session.beginTransaction();
      session.delete(planet);
      tx.commit();
    }
  }

}
