package org.example.dao;

import org.example.cofig.Configyration;
import org.example.enitty.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDao {
  private SessionFactory sessionFactory = Configyration.getInstance().getSessionFactory();

  public void save(Client client) {
    try (Session session = sessionFactory.openSession()) {
      Transaction transaction = session.beginTransaction();
      session.save(client);
      transaction.commit();
    }
  }


  public Client findById(Long id) {
    try (Session session = sessionFactory.openSession()) {
      return session.get(Client.class, id);
    }
  }


  public void update(Client client) {
    try (Session session = sessionFactory.openSession()) {
      Transaction tx = session.beginTransaction();
      session.update(client);
      tx.commit();
    }
  }

  public void delete(Client client) {
    try (Session session = sessionFactory.openSession()) {
      Transaction tx = session.beginTransaction();
      session.delete(client);
      tx.commit();
    }
  }

}
