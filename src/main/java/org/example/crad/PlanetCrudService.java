package org.example.crad;

import org.example.dao.Planetdao;
import org.example.enitty.Planet;

import java.util.ArrayList;

public class PlanetCrudService {
  private Planetdao planetdao = new Planetdao();

  public void savePlanet(Planet planet) {
    planetdao.save(planet);
  }

  public Planet findPlanetById(String id) {
    return planetdao.findById(id);
  }

  public void updatePlanet(Planet planet) {
    planetdao.update(planet);
  }

  public void deletePlanet(Planet planet) {
TicetCrudService ticetCrudService=new TicetCrudService();
    ArrayList<Long> idTiket=new ArrayList<>();
    idTiket=ticetCrudService.idTicetPlanet(planet.getId());
    for (long ids:idTiket) {
    ticetCrudService.DeliteTicet(ticetCrudService.FindById(ids));
    }

    planetdao.delete(planet);
  }
}
