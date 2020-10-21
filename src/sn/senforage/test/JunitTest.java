package sn.senforage.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sn.senforage.dao.ClientImpl;
import sn.senforage.dao.IClient;
import sn.senforage.entities.Client;

public class JunitTest {

    @Before
    public void beforeTest() {
        System.out.println("=====Before=====");

    }

    @After
    public void afterTest() {
        System.out.println("=====After=====");

    }

    /*@Test
    public void testAddClient() {
        IClient clientdao = new ClientImpl();
        Client client = new Client();
        client.setNomFamille("SECK");
        client.setVillage("Daff");
        client.setAdresse("Mbayenne, 12");
        client.setNumTel("987654321");

        clientdao.add(client);

    }*/
}
