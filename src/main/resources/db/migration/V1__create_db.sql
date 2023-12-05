-- «м≥ни використовуючи AUTO_INCREMENT дл€ ID у таблиц≥ Client
CREATE TABLE Client (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3)
);

-- «м≥ни дл€ стовпц€ ID у таблиц≥ Planet
CREATE TABLE Planet (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(500) NOT NULL
);

-- «м≥ни дл€ стовпц≥в ID у таблиц≥ Ticket
CREATE TABLE Ticket (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id INT,
    from_planet_id VARCHAR(10),
    to_planet_id VARCHAR(10),
    FOREIGN KEY (client_id) REFERENCES Client(id),
    FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
    FOREIGN KEY (to_planet_id) REFERENCES Planet(id)
);
