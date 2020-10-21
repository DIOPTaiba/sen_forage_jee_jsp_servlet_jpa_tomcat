package sn.senforage.dao;

import sn.senforage.entities.Utilisateur;

import java.util.List;

public interface IUtilisateur {

    public int add(Utilisateur utilisateur);
    public List<Utilisateur> listUtilisateur();
    public Utilisateur getUserById(String idUser);
}
