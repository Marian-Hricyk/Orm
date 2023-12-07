package org.example.enitty;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "Ticket")
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "created_at")
  private Timestamp created_at;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client_id;

  @ManyToOne
  @JoinColumn(name = "from_planet_id")
  private Planet from_planet_id;

  @ManyToOne
  @JoinColumn(name = "to_planet_id")
  private Planet to_planet_id;
}
