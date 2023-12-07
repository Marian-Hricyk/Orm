package org.example.crad;

import org.example.dao.ClientDao;
import org.example.enitty.Client;

import java.util.ArrayList;

public class ClientCrudService {
  private ClientDao clientDao = new ClientDao();

  public void saveClient(Client client) {
    clientDao.save(client);
  }

  public Client findClientById(long id) {
    return clientDao.findById(id);
  }

  public void updateClient(Client client) {
    clientDao.update(client);
  }

  public void deleteClient(Client client) {
    TicetCrudService ticetCrudService=new TicetCrudService();
    ArrayList<Long> idTiket=new ArrayList<>();
    idTiket=ticetCrudService.idTicetCient(client.getId());
    for (long ids:idTiket) {
      ticetCrudService.DeliteTicet(ticetCrudService.FindById(ids));
    }
    clientDao.delete(client);
  }
}
