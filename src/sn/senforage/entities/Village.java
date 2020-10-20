package sn.senforage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Village {

    @Id
    private String idVillage;
    private String nom;

    public Village() {
    }

    public Village(String idVillage, String nom) {
        this.idVillage = idVillage;
        this.nom = nom;
    }

    public String getIdVillage() {
        return idVillage;
    }

    public void setIdVillage(String idVillage) {
        this.idVillage = idVillage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
