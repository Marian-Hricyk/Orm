package org.example;


import org.example.cofig.Configyration;
import org.example.crad.ClientCrudService;
import org.example.crad.PlanetCrudService;
import org.example.enitty.Client;
import org.example.enitty.Planet;

public class Main {
  public static void main(String[] args) {
    Configyration.getInstance();
    PlanetCrudService planetCrudService=new PlanetCrudService();
    ClientCrudService clientCrudService=new ClientCrudService();

    Planet newPlanet=new Planet();
    newPlanet.setName("CAT");
    planetCrudService.savePlanet(newPlanet);

    Planet planet=planetCrudService.findPlanetById(1L);
    System.out.println("Found Planet: " + planet.getName());

planet.setName("Man");
    planetCrudService.updatePlanet(planet);

    planetCrudService.deletePlanet(planet);


    Client newCliant =new Client();
    newCliant.setName("jis");
    clientCrudService.saveClient(newCliant);

    Client client=clientCrudService.findClientById(1L);
    System.out.println("Found Cliant: " + client.getName());

    client.setName("Ostap");
clientCrudService.updateClient(client);

    clientCrudService.deleteClient(client);

  }
}