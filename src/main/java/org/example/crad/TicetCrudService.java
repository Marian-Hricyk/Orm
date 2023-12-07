package org.example.crad;

import org.example.dao.Ticetdao;
import org.example.enitty.Ticket;

import java.util.ArrayList;

public class TicetCrudService {
  Ticetdao ticetdao=new Ticetdao();

  public Ticket FindById (long id){
    return ticetdao.findById(id);
  }

  public ArrayList<Long> idTicetPlanet(String id){
    return ticetdao.idTicketWithPlanetId(id);
  }

  public ArrayList<Long> idTicetCient(long id){
    return ticetdao.idTicketWithClientId(id);
  }

  public void DeliteTicet(Ticket ticket){
    ticetdao.delete(ticket);
  }
}
