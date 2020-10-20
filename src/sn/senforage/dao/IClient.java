package sn.senforage.dao;

import sn.senforage.entities.Client;

import java.util.List;

public interface IClient {

    public int add(Client client);
    public List<Client> list();
}
