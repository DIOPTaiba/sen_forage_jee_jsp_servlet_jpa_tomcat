package sn.senforage.test;

import sn.senforage.dao.*;
import sn.senforage.entities.Client;
import sn.senforage.entities.Utilisateur;
import sn.senforage.entities.Village;

public class Test {

    public static void main(String[] args){


        /*IUtilisateur utilisateurdao = new UtilisateurImpl();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setIdUser("773511003");
        utilisateur.setNom("DIOP");
        utilisateur.setPrenom("Mor");
        utilisateur.setEmail("mordioptaiba@gmail.com");
        utilisateur.setPassword("passer");

        int ok = utilisateurdao.add(utilisateur);
        System.out.println(ok);*/


        /*IClient clientdao = new ClientImpl();

        Client client = new Client();
        client.setNomFamille("DIOP");
        client.setVillage("Taïba Ndiaye");
        client.setAdresse("Ndiop");
        client.setNumTel("773511003");

        int ok = clientdao.add(client);
        System.out.println(ok);*/

        IVillage villagedao = new VillageImpl();

        Village village = new Village();
        village.setIdVillage("TN100");
        village.setNom("Taïba Ndiaye");

        int ok = villagedao.add(village);
        System.out.println(ok);

    }
}
