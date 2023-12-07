package org.example.dao;

import org.example.cofig.Configyration;
import org.example.enitty.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class Ticetdao {
  private SessionFactory sessionFactory = Configyration.getInstance().getSessionFactory();

  public void delete(Ticket ticket) {
    try (Session session = sessionFactory.openSession()) {
      Transaction tx = session.beginTransaction();
      session.delete(ticket);
      tx.commit();
    }
  }

  public ArrayList<Long> idTicketWithPlanetId(String id) {
    ArrayList<Long> ticketIds = new ArrayList<>();

    try (Session session = sessionFactory.openSession()) {
      Query<Long> query = session.createQuery("SELECT t.id FROM Ticket t " + "WHERE t.from_planet_id.id = :planetId OR t.to_planet_id.id = :planetId", Long.class);
      query.setParameter("planetId", id);


      ticketIds.addAll(query.getResultList());
    }

    return ticketIds;
  }


  public ArrayList<Long> idTicketWithClientId(long id) {
    ArrayList<Long> ticketIds = new ArrayList<>();

    try (Session session = sessionFactory.openSession()) {
      Query<Long> query = session.createQuery("SELECT t.id FROM  Ticket t " + "WHERE t.client_id = :clientId", Long.class);
      query.setParameter("clientId", id);

      ticketIds.addAll(query.getResultList());
    }

    return ticketIds;
  }

  public Ticket findById(long id) {
    try (Session session = sessionFactory.openSession()) {
      return session.get(Ticket.class, id);
    }
  }
}
