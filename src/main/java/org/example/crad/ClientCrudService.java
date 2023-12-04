package org.example.crad;

import org.example.dao.ClientDao;
import org.example.enitty.Client;

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
    clientDao.delete(client);
  }
}
