package org.example.enitty;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Planet")
public class Planet {
  @Id
  private String id;

  @Column
  private String name;

}
