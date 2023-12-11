package org.example.enitty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Ticket")
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "created_at")
  private LocalDateTime created_at;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "from_planet_id")
  private Planet fromPlanet;

  @ManyToOne
  @JoinColumn(name = "to_planet_id")
  private Planet toPlanet;


}
