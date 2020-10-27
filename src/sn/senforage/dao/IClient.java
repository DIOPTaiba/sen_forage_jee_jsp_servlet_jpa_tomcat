package sn.senforage.dao;

import sn.senforage.entities.Client;
import sn.senforage.entities.Village;

import java.util.List;

public interface IClient {

    public int add(Client client);
    public List<Client> listClient();
}
