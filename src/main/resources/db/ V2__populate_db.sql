INSERT INTO Client (name) VALUES
  ('John Doe'),
  ('Alice Smith'),
  ('Bob Johnson'),
  ('Eva Brown'),
  ('Michael White'),
  ('Olivia Davis'),
  ('David Wilson'),
  ('Sophia Lee'),
  ('William Turner'),
  ('Emma Taylor');

  INSERT INTO Planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VENUS', 'Venus'),
    ('EARTH', 'Earth'),
    ('JUPITER', 'Jupiter'),
    ('SATURN', 'Saturn');

    INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES
      (1, 'MARS', 'VENUS'),
      (2, 'EARTH', 'MARS'),
      (3, 'JUPITER', 'SATURN'),
      (4, 'VENUS', 'EARTH'),
      (5, 'SATURN', 'JUPITER'),
      (6, 'MARS', 'EARTH'),
      (7, 'EARTH', 'VENUS'),
      (8, 'MARS', 'JUPITER'),
      (9, 'JUPITER', 'EARTH'),
      (10, 'SATURN', 'VENUS');