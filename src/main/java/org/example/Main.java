package org.example;


import org.example.cofig.Configyration;
import org.example.crad.ClientCrudService;
import org.example.crad.PlanetCrudService;
import org.example.crad.TicetCrudService;
import org.example.enitty.Client;
import org.example.enitty.Planet;
import org.example.enitty.Ticket;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Configyration.getInstance();
    PlanetCrudService planetCrudService = new PlanetCrudService();
    ClientCrudService clientCrudService = new ClientCrudService();
    TicetCrudService ticetCrudService = new TicetCrudService();

    Planet newPlanet = new Planet();
    newPlanet.setId("CAT");
    newPlanet.setName("cat");
    planetCrudService.savePlanet(newPlanet);

    Planet planet = planetCrudService.findPlanetById("MARS");


    planet.setName("Mars");
    planetCrudService.updatePlanet(planet);

    planetCrudService.deletePlanet(planet);


    Client newCliant = new Client();
    newCliant.setName("jis");
    clientCrudService.saveClient(newCliant);

    Client client = clientCrudService.findClientById(1L);
    System.out.println("Found Cliant: " + client.getName());

    client.setName("Ostap");
    clientCrudService.updateClient(client);

    clientCrudService.deleteClient(client);


    Ticket newTicket = new Ticket();

    ticetCrudService.saveTicet(newTicket);

    long id = 3L;

    Ticket foundTicket = ticetCrudService.FindById(id);
    if (foundTicket != null) {
      ticetCrudService.updateTicet(foundTicket);
      ticetCrudService.DeliteTicet(foundTicket);
    } else {
      System.out.println("Ticket with ID " + id + " not found.");
    }


  }
}